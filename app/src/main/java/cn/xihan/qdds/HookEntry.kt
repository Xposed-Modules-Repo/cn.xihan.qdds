package cn.xihan.qdds

import android.content.SharedPreferences
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.highcapable.yukihookapi.YukiHookAPI
import com.highcapable.yukihookapi.annotation.xposed.InjectYukiHookWithXposed
import com.highcapable.yukihookapi.hook.xposed.proxy.IYukiHookXposedInit
import de.robv.android.xposed.XSharedPreferences


/**
 * @项目名 : BaseHook
 * @作者 : MissYang
 * @创建时间 : 2022/7/4 16:32
 * @介绍 :
 */
@InjectYukiHookWithXposed(modulePackageName = "cn.xihan.qdds", entryClassName = "HookEntryInit")
class HookEntry : IYukiHookXposedInit {

    override fun onInit() {
        YukiHookAPI.configs {
            debugTag = "yuki"
            isDebug = BuildConfig.DEBUG
        }
    }

    override fun onHook() = YukiHookAPI.encase {

        loadApp(name = prefs.getString("packageName")) {
            onAppLifecycle {
                // 你可以在这里实现 Application 中的生命周期方法监听
                attachBaseContext { baseContext, hasCalledSuper ->
                    // 通过判断 hasCalledSuper 来确定是否已执行 super.attachBaseContext(base) 方法
                    // ...
                    if (hasCalledSuper) {
                        /**
                         * 获取应用版本号
                         */
                        versionCode = baseContext.packageManager.getPackageInfo(
                            prefs.getString("packageName"),
                            0
                        ).versionCode
                    }
                }
            }


            /**
             * 是否自动签到
             */
            if (prefs.getBoolean("isEnableAutoSign", false)) {
                if (prefs.getBoolean("isEnableOldLayout", false)) {
                    /**
                     * 旧版布局的自动签到
                     */
                    findClass(classNameAndMethodNameEntity.getOldLayoutSignInClassNameAndMethodName()[0]).hook {
                        injectMember {
                            method {
                                name =
                                    classNameAndMethodNameEntity.getOldLayoutSignInClassNameAndMethodName()[1]
                            }
                            afterHook {
                                val m = getView<TextView>(
                                    instance,
                                    classNameAndMethodNameEntity.getOldLayoutSignInClassNameAndMethodName()[2]
                                )
                                val l = getView<LinearLayout>(
                                    instance,
                                    classNameAndMethodNameEntity.getOldLayoutSignInClassNameAndMethodName()[3]
                                )
                                m?.let {
                                    if (it.text == "签到") {
                                        l?.performClick()
                                    }
                                }
                            }
                        }
                    }
                } else {
                    /**
                     * 新版布局的自动签到
                     */
                    findClass(classNameAndMethodNameEntity.getNewLayoutSignInClassNameAndMethodName()[0]).hook {
                        injectMember {
                            method {
                                name =
                                    classNameAndMethodNameEntity.getNewLayoutSignInClassNameAndMethodName()[1]
                            }
                            afterHook {
                                val s = getView<LinearLayout>(
                                    instance,
                                    classNameAndMethodNameEntity.getNewLayoutSignInClassNameAndMethodName()[2]
                                )
                                val qd = getParam<Any>(
                                    instance,
                                    classNameAndMethodNameEntity.getNewLayoutSignInClassNameAndMethodName()[2]
                                )
                                qd?.let { qdv ->
                                    val e = getView<TextView>(
                                        qdv,
                                        classNameAndMethodNameEntity.getNewLayoutSignInClassNameAndMethodName()[3]
                                    )
                                    e?.let { etv ->
                                        if (etv.text == "签到") {
                                            s?.performClick()
                                        }
                                    }
                                }
                            }
                        }

                    }

                }
            }

            /**
             * 是否启用旧版布局
             */
            if (prefs.getBoolean("isEnableOldLayout")) {
                findClass(classNameAndMethodNameEntity.getIsEnableOldLayoutClassNameAndMethodName()[0]).hook {
                    injectMember {
                        method {
                            name =
                                classNameAndMethodNameEntity.getIsEnableOldLayoutClassNameAndMethodName()[1]
                        }
                        replaceToFalse()
                    }
                }
            }

            /**
             * 是否启用本地至尊卡
             */
            if (prefs.getBoolean("isEnableLocalCard")) {
                findClass(classNameAndMethodNameEntity.getIsEnableLocalCardClassNameAndMethodName()[0]).hook {
                    injectMember {
                        method {
                            name =
                                classNameAndMethodNameEntity.getIsEnableLocalCardClassNameAndMethodName()[1]
                        }
                        replaceTo(2)
                    }

                    injectMember {
                        method {
                            name =
                                classNameAndMethodNameEntity.getIsEnableLocalCardClassNameAndMethodName()[2]
                        }
                        replaceTo(1)
                    }

                }

            }

            /**
             * 是否移除书架右下角浮窗
             */
            if (prefs.getBoolean("isEnableRemoveBookshelfFloat")) {
                findClass(classNameAndMethodNameEntity.getIsEnableRemoveBookshelfFloatClassNameAndMethodName()[0]).hook {
                    injectMember {
                        method {
                            name =
                                classNameAndMethodNameEntity.getIsEnableRemoveBookshelfFloatClassNameAndMethodName()[1]
                            param(View::class.java)
                        }

                        afterHook {
                            val imgBookShelfActivityIcon =
                                getView<ImageView>(
                                    instance,
                                    classNameAndMethodNameEntity.getIsEnableRemoveBookshelfFloatClassNameAndMethodName()[2]
                                )
                            imgBookShelfActivityIcon?.visibility = View.GONE

                            val layoutImgAdIcon = getView<LinearLayout>(
                                instance,
                                classNameAndMethodNameEntity.getIsEnableRemoveBookshelfFloatClassNameAndMethodName()[3]
                            )
                            layoutImgAdIcon?.visibility = View.GONE
                        }


                    }

                }

            }

            /**
             * 是否去除底部导航栏中心广告
             */
            if (prefs.getBoolean("isEnableRemoveBookshelfBottomAd")) {
                findClass(classNameAndMethodNameEntity.getIsEnableRemoveBookshelfBottomAdClassNameAndMethodName()[0]).hook {
                    injectMember {
                        method {
                            name =
                                classNameAndMethodNameEntity.getIsEnableRemoveBookshelfBottomAdClassNameAndMethodName()[1]
                        }
                        replaceUnit {

                        }


                    }
                }
            }

        }
    }


    companion object {

        var versionCode = 0

        val classNameAndMethodNameEntity by lazy { ClassNameAndMethodNameEntity(versionCode) }

        fun getPref(): SharedPreferences? {
            val pref = XSharedPreferences(BuildConfig.APPLICATION_ID)
            return if (pref.file.canRead()) pref else null
        }

    }

    /**
     * 返回类名和方法名
     */

    data class ClassNameAndMethodNameEntity(val versionCode: Int) {

        /**
         * 根据版本号获取旧版布局自动签到类名方法名字段名数组
         */
        fun getOldLayoutSignInClassNameAndMethodName(): Array<String> {
            return when (versionCode) {
                758 -> arrayOf(
                    "com.qidian.QDReader.ui.view.bookshelfview.CheckInReadingTimeView",
                    "S",
                    "m",
                    "l"
                )
                else -> arrayOf(
                    "com.qidian.QDReader.ui.view.bookshelfview.CheckInReadingTimeView",
                    "S",
                    "m",
                    "l"
                )
            }
        }

        /**
         * 根据版本号获取新版布局自动签到类名方法名字段名数组
         */
        fun getNewLayoutSignInClassNameAndMethodName(): Array<String> {
            return when (versionCode) {
                758 -> arrayOf(
                    "com.qidian.QDReader.ui.view.bookshelfview.CheckInReadingTimeViewNew",
                    "E",
                    "s",
                    "e"
                )
                else -> arrayOf(
                    "com.qidian.QDReader.ui.view.bookshelfview.CheckInReadingTimeViewNew",
                    "E",
                    "s",
                    "e"
                )
            }
        }

        /**
         * 根据版本号获取是否启用旧版布局的类名方法名字段名数组
         */
        fun getIsEnableOldLayoutClassNameAndMethodName(): Array<String> {
            return when (versionCode) {
                758 -> arrayOf(
                    "com.qidian.QDReader.component.config.QDAppConfigHelper\$Companion",
                    "getBookShelfNewStyle"
                )
                else -> arrayOf(
                    "com.qidian.QDReader.component.config.QDAppConfigHelper\$Companion",
                    "getBookShelfNewStyle"
                )
            }
        }

        /**
         * 根据版本号获取是否启用本地至尊卡的类名方法名字段名数组
         */
        fun getIsEnableLocalCardClassNameAndMethodName(): Array<String> {
            return when (versionCode) {
                758 -> arrayOf(
                    "com.qidian.QDReader.repository.entity.UserAccountDataBean\$MemberBean",
                    "getMemberType",
                    "getIsMember"
                )
                else -> arrayOf(
                    "com.qidian.QDReader.repository.entity.UserAccountDataBean\$MemberBean",
                    "getMemberType",
                    "getIsMember"
                )
            }
        }

        /**
         * 根据版本号获取是否移除书架右下角浮窗的类名方法名字段名数组
         */
        fun getIsEnableRemoveBookshelfFloatClassNameAndMethodName(): Array<String> {
            return when (versionCode) {
                758 -> arrayOf(
                    "com.qidian.QDReader.ui.fragment.QDBookShelfPagerFragment",
                    "onViewInject",
                    "imgBookShelfActivityIcon",
                    "layoutImgAdIcon"
                )
                else -> arrayOf(
                    "com.qidian.QDReader.ui.fragment.QDBookShelfPagerFragment",
                    "onViewInject",
                    "imgBookShelfActivityIcon",
                    "layoutImgAdIcon"
                )
            }


        }

        /**
         * 根据版本号获取是否移除底部导航栏中心广告的类名方法名字段名数组
         */
        fun getIsEnableRemoveBookshelfBottomAdClassNameAndMethodName(): Array<String> {
            return when (versionCode) {
                758 -> arrayOf(
                    "com.qidian.QDReader.ui.activity.MainGroupActivity\$t",
                    "c"
                )
                else -> arrayOf(
                    "com.qidian.QDReader.ui.activity.MainGroupActivity\$t",
                    "c"
                )
            }
        }
    }
}


/**
 * 通过反射获取控件
 * @param param 参数
 * @param name 字段名
 */
@Throws(NoSuchFieldException::class, IllegalAccessException::class)
inline fun <reified T : View> getView(param: Any, name: String): T? {
    return getParam<T>(param, name)
}

/**
 * 反射获取任何类型
 */
@Throws(NoSuchFieldException::class, IllegalAccessException::class)
inline fun <reified T> getParam(param: Any, name: String): T? {
    val clazz: Class<*> = param.javaClass
    val field = clazz.getDeclaredField(name)
    field.isAccessible = true
    return field[param] as? T
}
