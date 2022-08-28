# QDReadHook

![above](https://img.shields.io/badge/Android-7.0%20or%20above-brightgreen.svg)
[![Latest Release](https://img.shields.io/github/release/Xposed-Modules-Repo/cn.xihan.qdds.svg)](../../releases)
![downloads](https://img.shields.io/github/downloads/Xposed-Modules-Repo/cn.xihan.qdds/total)

---

## 起点阅读 Xp模块

使用 [YukiHookAPI](https://github.com/fankes/YukiHookAPI)

* 使用前注意给予起点存储权限!!!(1.1.2+)

* 已支持动态配置,在起点-我的-左上角设置里面-阅读设置/模块设置(长按)(1.1.2+)

* 目前支持 758~768、772、776、780、784、788、792版本

* 暂时提高版本号范围以支持一些不容易改变的类

* [支持的版本合集](https://xihan.lanzouv.com/b0413c6he) 密码:xihan

### 主要功能如下

---

* 自动签到

* 新旧布局

* 本地至尊卡

* 隐藏底部小红点

* 彻底关闭青少年模式弹框(1.0.2+)

### 广告相关

---

* 移除书架右下角浮窗

        ps:简单粗暴拦截网络连接,反射获取控件隐藏

* 移除底部导航栏中心广告

        ps:简单粗暴拦截网络连接

* 移除我-中心广告

        ps:简单粗暴拦截网络连接

* 禁止检测更新(1.0.7+)

        ps:简单粗暴拦截相关方法

* 禁用广告

  * 每日导读广告(1.1.0+)

  * 启动页广告

  * GDT广告
  
        ps:简单粗暴拦截广告sdk动态加载以及网络连接

### 屏蔽相关(1.1.0+ 支持788+版本)

---

* 屏蔽选项列表(自选)

  * 0.搜索-发现(热词)

  * 1.搜索-热门作品榜
  * 2.搜索-人气标签榜
  * 3.搜索-为你推荐
  * 4.精选-主页面
  * 5.精选-分类
  * 6.精选-免费-免费推荐
  * 7.精选-分类-全部作品
  * 8.精选-免费-新书入库
  * 9.精选-畅销精选、主编力荐等更多
  * 10.精选-新书强推、三江推荐
  * 11.精选-新书(1.1.4+)
  * 12.每日导读

* 需要屏蔽的作者列表

        ps:填入完整作者名称

* 需要屏蔽的书名关键词

        ps:单字威力巨大!!!甚至可能导致看上去布局显示错乱。多个关键词使用方法举例:"心声;四合院;不想",用英文的";"

* 书类型增强屏蔽(1.1.2+)

        ps:开启后所有类型里面关键词对上就会触发屏蔽，如"仙侠"则会"古典仙侠"、"XX仙侠"只要包括了"仙侠"二字，所以依然是单字威力巨大!!!

* 需要屏蔽书的类型

        ps:填入完整的如"仙侠"，但是"古典仙侠"不会被屏蔽，需要再加入"古典仙侠"。后期可能会加入加强版,多个关键词使用方法如上

#### 效果图

![精选-主页面](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/精选-主页面.jpg?raw=true)
![全部作品-分类](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/全部作品-分类.jpg?raw=true)

---

### 闪屏页相关

---

* 闪屏页开关

        ps:启用后恢复网络请求

#### 自定义闪屏页

* 启用显示全部按钮

        ps:关闭可以理解为纯图片无发触发自定义跳转

* 自定义触发跳转书籍详情

        ps:可选跳转到书籍

* 自定义闪屏类型

        ps:原生的2种类型，上滑点击和纯按钮

* 自定义闪屏图片

        ps:需要本地图片的绝对地址,用的是原生方法,只修改了其中图片路径的地址参数,如是起点私有目录下的无需存储权限

---

### 隐藏控件相关(1.1.3+)

* 搜索一刀切(1.1.4+)

        可能导致搜索历史也无法看见喔!~

* 隐藏底部导航栏-发现

* 我-隐藏控件(自选,开启后重启应用即可获取到列表)

#### 效果图

![我-隐藏控件](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/我-隐藏控件.jpg?raw=true)
![我-隐藏控件](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/搜索一刀切.jpg?raw=true)

---

## 截图

![image1](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/1.jpg?raw=true)
![image2](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/2.jpg?raw=true)
![image3](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/3.jpg?raw=true)
![image4](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/4.jpg?raw=true)
![image5](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/5.jpg?raw=true)
![image6](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/6.jpg?raw=true)
![image7](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/7.jpg?raw=true)
---

## 常见问题

* 开关功能不生效

        注意看上述所提到支持的版本号

        1.1.2版本以前如还不生效则查看/data/misc/某个文件夹/prefs/cn.xihan.qdds 这个文件夹权限是否可读,如果不可读手动设置一下，每次修改了配置都需要修改此权限,并应用子文件 权限 都设定为755最佳。还不行就把模块卸载了重新安装，激活后先去把配置调整好，再去上述路径改权限，完事最好清下起点数据，打开就完美了!!!

        1.1.2及以后则查看起点是否有存储权限，查看是否存在"/sdcard/QDReader/option.json"这个文件

* 没开启闪屏页却一直显示闪屏页

        这种情况一般是因为本地已经有缓存了,最简单的方法是清除起点的数据,把要开的功能提前开好

* 开启去广告无效

        和上述一致，清数据重启即可

* ~~目前去青少年模式弹框仅仅只是防止频繁弹，不是完全去掉,我之前测试用隔一会弹一下，开启后仅弹一次~~ 1.0.2+版本是通过 Hook 自定义Dialog 的 **show()** 方法，可能有副作用，暂时未发现

* ~~模块初次使用建议操作流程~~1.1.2及以上无需此操作，授予起点存储权限即可

        1.安装好模块后把模块和起点都强行停止运行
        2.激活(勾选)模块
        3.打开模块配置好相关选项
        4.强行停止模块运行
        5.修改上述所提到的文件夹权限
        6.清除起点数据
        7.打开起点

---

## Lspatch使用说明

* 安装后启动前需要授予起点存储权限!!!要不然无法读取配置文件则不会生效,或者你设定错了可能会使用默认配置

* 已支持动态配置(1.1.2+)

* 因为修改了签名,所以快速登录无法使用,只能用手机号登录!!!所以如果可以还是使用 Xp 模式

---

## 如果觉得这个模块对您有用，可扫描下方二维码随意打赏,要是能打赏个 10.24 🐵就太👍了。您的支持就是我更新的动力

![zfb](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/zfb.jpg?raw=true)
![wx](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/wx.png?raw=true)
![qq](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/qq.png?raw=true)
