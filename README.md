# QDReadHook

![above](https://img.shields.io/badge/Android-7.0%20or%20above-brightgreen.svg)
[![Latest Release](https://img.shields.io/github/release/Xposed-Modules-Repo/cn.xihan.qdds.svg)](../../releases)
![downloads](https://img.shields.io/github/downloads/Xposed-Modules-Repo/cn.xihan.qdds/total)

---

## 起点阅读 Xp模块

使用 [YukiHookAPI](https://github.com/fankes/YukiHookAPI)

* 使用前注意给予起点存储权限!!!(1.1.2+)

* 已支持动态配置,在起点-我的-左上角设置里面-阅读设置/模块设置(长按)(1.1.2+)

* 目前支持 758~768、772、776、780、784、788、792、796、800、804、808、812、827、834、842、843版本

* 暂时提高版本号范围以支持一些不容易改变的类

* 1.2.7+ 配置文件路径为 "/sdcard/Download/QDReader",会自行移动原配置文件并删除原配置文件目录,注意原配置文件目录不要有重要文件

* 下载地址

  * [支持的版本合集蓝奏云](https://xihan.lanzouv.com/b0413c6he) 密码:xihan

  * [酷安](https://www.coolapk.com/apk/5066/)

  * [官方网站](https://www.yuewen.com/app.html#appqd)
  
* QD模块交流群: [727983520](https://qm.qq.com/cgi-bin/qm/qr?k=JT0K0sZEJHm4CnsRjRTKxY3uL-xoO6CG&jump_from=webapi&authKey=yGg3h07NWBGGF4TmxtRNykIQ4HLM4t/uxrAtqHx15zgRmIR4sC14HxKYOq376ekt") <a target="_blank" href="https://qm.qq.com/cgi-bin/qm/qr?k=JT0K0sZEJHm4CnsRjRTKxY3uL-xoO6CG&jump_from=webapi&authKey=yGg3h07NWBGGF4TmxtRNykIQ4HLM4t/uxrAtqHx15zgRmIR4sC14HxKYOq376ekt"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="QD模块交流群" title="QD模块交流群"></a>

### 主要功能如下

---

* 自动签到

* 新旧布局(800+版本已不存在旧版布局)

* 旧书架布局(827+||1.3.0+)

* 本地至尊卡

* 解锁会员卡专属背景(827+||1.3.1+)

* 自定义阅读页背景路径(827+||1.3.1+)

      自定义的路径目前为: "/sdcard/Download/QDReader/ReaderTheme/"
      首先去个性化背景随便下载一个并且应用，然后到上面的路径里面去替换相应内容，重启起点就可以看到效果了，不是所有图片都可以，具体自己试，模板图片等我会一并放到网盘
      最少需要一个背景图，预览图无所谓，其次都要使用十六进制颜色代码，具体可参考模板
      另外其实还支持PAG动画，但是不建议弄，弄不好掉帧严重，看反馈的多我就顺便教一下咋加上

```json
 {
  "colors": {
    // 字体颜色    
    "font": "#203322",
    // 背景颜色
    "background": "#E6F1E3",
    // 背景高亮颜色
    "backgroundLight": "#F8FFF8",
    // 高亮颜色
    "highLight": "#336C47",
    // tint颜色
    "tint": "#336C47"
  },
  "version": 1,
  // 预览图
  "previewImage": "slice_bg.png",
  "bg": {
    // 忘记干啥的了 不建议改
    "type": 2,
    // 背景图片名称
    "image": "readBg.jpg"
  }
}

 ```

 #### 效果图

![阅读页背景设置](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/阅读页背景设置.png?raw=true)
![阅读页背景设置文件](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/阅读页背景设置文件.png?raw=true)
![阅读页背景](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/阅读页背景.png?raw=true)
---
 
### 广告相关

---

* 禁用GDT广告

* 检查更新

* 禁用每日导读广告(1.2.8+|812+)

* 禁用书架活动弹框(1.1.8+)

* 禁用书架右下角浮窗

* 禁用底部导航栏中心广告

* 禁用我-中心广告

* 阅读页相关

  * 浮窗广告(1.2.6|812+)

  * 打赏小剧场(1.2.8+|812+)
  * 章节章末一刀切(1.2.9+|812+)
  * 章末本章说(1.2.9+|812+)
  * 章末新人推书(1.2.9+|812+)
  * 章末福利(1.2.9+|812+)
  * 章末广告(1.2.9+|812+)
  * 章末求票(1.2.9+|812+)
  * 章末底部月票打赏红包(827+||1.3.1+)
  
* 禁止检测更新(1.0.7+)

#### 效果图

![阅读页-章末](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/阅读页-章末.jpg?raw=true)

---

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
  * 11.精选-排行榜(1.2.2+|808+)
  * 12.精选-新书(1.1.4+)
  * 13.每日导读
  * 14.精选-漫画(1.2.8+|812+)
  * 15.精选-漫画-其他(1.2.8+|812+)

* 需要屏蔽的作者列表

        ps:填入完整作者名称

* 需要屏蔽的书名关键词

        ps:单字威力巨大!!!甚至可能导致看上去布局显示错乱。多个关键词使用方法举例:"心声;四合院;不想",用英文的";"

* 书类型增强屏蔽(1.1.2+)

        ps:开启后所有类型里面关键词对上就会触发屏蔽，如"仙侠"则会"古典仙侠"、"XX仙侠"只要包括了"仙侠"二字，所以依然是单字威力巨大!!!

* 需要屏蔽书的类型

      ps:填入完整的如"仙侠"，但是"古典仙侠"不会被屏蔽，需要再加入"古典仙侠"。多个关键词使用方法如上

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

* 主页-隐藏控件

  * 隐藏主页顶部宝箱提示(1.2.5+|812+)

  * 隐藏书架-每日导读(1.1.9+)
  * 隐藏底部导航栏红点
  * 隐藏底部导航栏-发现

* 搜索一刀切(1.1.4+)

        可能导致搜索历史也无法看见喔!~

* 彻底关闭青少年模式弹框(1.0.2+)

* 隐藏漫画轮播图广告(1.2.8+|812+)

* 隐藏我-右上角消息红点(1.2.4+|812+)

* 我-隐藏控件(自选,开启后重启应用即可获取到列表)

* 书籍详情-隐藏控件(自选，开启后重启应用生效)(1.2.3+|808+)

  * 出圈指数

  * 荣誉标签
  * QQ群
  * 书友圈
  * 书友榜
  * 月票金主
  * 本书看点|中心广告
  * 浮窗广告
  * 同类作品推荐
  * 看过此书的人还看过

#### 效果图

![书架](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/书架.jpg?raw=true)
![我-隐藏控件](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/我-隐藏控件.jpg?raw=true)
![搜索一刀切](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/搜索一刀切.jpg?raw=true)
![书籍详情-隐藏控件](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/书籍详情-隐藏控件.jpg?raw=true)

---

### 替换相关(1.2.6+|812+)

* 净化替换章节标题以及正文

        不清楚或者不明白的请不要随意打开使用。可使用正则表达式或者字符串进行替换,开关需要重启应用,启用后规则更改实时生效

        规则的最简单使用例子:如果正文中出现"东躲XC"、"XZ"，被屏蔽的词为"西藏",即可用正则表达式"XC|XZ"替换为"西藏"。亦或者感觉主角或配角名冒犯到你，即可新建一个规则，"龙傲天" -> "凤傲天"

        规则是全局的，目前不支持指定书名等。规则最好不要重复或者冲突，不然可能会出现无法预料的错误,这种时候删除重复或者冲突的规则即可。如果不知道怎么用正则表达式，可以去网上学习一下或者酷安私信我，如果我有空，会帮你搞定

        点按编辑，长按删除

        目前只是简单的测试一下，后续不一定会继续维护或者更新此功能

#### 效果图

![书籍详情-隐藏控件](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/替换主角名-0.jpg?raw=true)
![书籍详情-隐藏控件](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/替换主角名-1.jpg?raw=true)

---

## 截图

![image1](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/1.jpg?raw=true)
![image2](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/2.png?raw=true)
![image3](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/3.png?raw=true)
![image4](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/4.png?raw=true)
![image5](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/5.png?raw=true)
![image6](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/6.png?raw=true)
![image7](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/7.jpg?raw=true)
![image8](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/8.png?raw=true)
![image9](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/9.jpg?raw=true)
![image10](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/10.png?raw=true)
---

## 常见问题

* 开关功能不生效

        注意看上述所提到支持的版本号

        1.1.2版本以前如还不生效则查看/data/misc/某个文件夹/prefs/cn.xihan.qdds 这个文件夹权限是否可读,如果不可读手动设置一下，每次修改了配置都需要修改此权限,并应用子文件 权限 都设定为755最佳。还不行就把模块卸载了重新安装，激活后先去把配置调整好，再去上述路径改权限，完事最好清下起点数据，打开就完美了!!!

        1.1.2及以后则查看起点是否有存储权限，查看是否存在"/sdcard/QDReader/option.json"这个文件(没有就创建一个)

        ps:根据版本不同，显示的路径可能也不同，可能是"/storage/emulated/0/QDReader/option.json".
        如果使用系统自带文件管理器，直接在"根目录(内部存储)"创建文件夹"QDReader"即可

        如果上述都不行，那就试着清除起点数据或者重装模块，也可能需要重启一下手机。

        还不行就附上日志提issues或酷安留言私信我即可(语气不要太冲，说的好像我欠你啥的，上来就质疑我的也不一定会回复。以为自己是谁啊，你用不了我就一定要让你也能用上，我还能远程施法单单让你用不了不成?)

* 没开启闪屏页却一直显示闪屏页

        这种情况一般是因为本地已经有缓存了,最简单的方法是清除起点的数据,把要开的功能提前开好

* 开启去广告无效

        和上述一致，清数据重启即可

* ~~目前去青少年模式弹框仅仅只是防止频繁弹，不是完全去掉,我之前测试用隔一会弹一下，开启后仅弹一次~~ 1.0.2+版本是通过 Hook 自定义Dialog 的 **show()** 方法，会导致投月票或者特殊订阅弹框不显示(1.1.6+已修复此问题) 1.1.6+是通过拦截上级调用

* ~~模块初次使用建议操作流程~~1.1.2及以上无需此操作，授予起点存储权限即可

        1.安装好模块后把模块和起点都强行停止运行
        2.激活(勾选)模块
        3.打开模块配置好相关选项
        4.强行停止模块运行
        5.修改上述所提到的文件夹权限
        6.清除起点数据
        7.打开起点

* 部分功能之前好好的，突然失效，**1.2.9+ 配置文件模型改变，部分设定需要重新设置!!!** 开关以及配置都正常却失效日志也没有。可以理解为被热修复了，一般来说更新最新版即可或者提Issues  

---

## Lspatch使用说明

* 安装后启动前需要授予起点存储权限!!!要不然无法读取配置文件则不会生效,或者你设定错了可能会使用默认配置

* 已支持动态配置(1.1.2+)

* 因为修改了签名,所以快速登录无法使用,只能用手机号登录!!!所以如果可以还是使用 Xp 模式

---

## 如果觉得这个模块对您有用，可扫描下方二维码随意打赏,要是能打赏个 10.24 🐵就太👍了。您的支持就是我更新的动力

<table>
<tr>
<td align=center>支付宝</td>
<td align=center>微信</td>
<td align=center>qq</td>
</tr>

<tr>
<td>
<img src="https://github.com/xihan123/QDReadHook/blob/master/Screenshots/zfb.jpg?raw=true" width=270 >
</td>
<td>
<img src="https://github.com/xihan123/QDReadHook/blob/master/Screenshots/wx.png?raw=true" width=270 >
</td>
<td>
<img src="https://github.com/xihan123/QDReadHook/blob/master/Screenshots/qq.png?raw=true" width=270 >
</td>
</tr>

</table>

---

## 亦或者饿了么扫个码支持也行

![image7](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/elm.png?raw=true)
