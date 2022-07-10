# QDReadHook

![](https://img.shields.io/badge/Android-7.0%20or%20above-brightgreen.svg)
[![Latest Release](https://img.shields.io/github/release/Xposed-Modules-Repo/cn.xihan.qdds.svg)](../../releases)
![](https://img.shields.io/github/downloads/Xposed-Modules-Repo/cn.xihan.qdds/total)

---

## 起点阅读 Xp模块

### 主要功能如下

---

* 自动签到

* 新旧布局

* 本地至尊卡

* 隐藏底部小红点

* 关闭青少年模式弹框

### 广告相关

---

* 移除书架右下角浮窗

        ps:简单粗暴拦截网络连接

* 移除底部导航栏中心广告

        ps:简单粗暴拦截网络连接

* 禁用TX系广告

        ps:简单粗暴拦截广告sdk动态加载以及网络连接

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

## [类名方法名字段名获取方法](Tutorial.md)

---

## 截图

![image](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/1.jpg?raw=true)
![image](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/2.jpg?raw=true)
![image](https://github.com/xihan123/QDReadHook/blob/master/Screenshots/3.jpg?raw=true)

---

## 常见问题

* 开关功能不生效

        注意看支持的版本,目前仅支持7.9.228-758~760

        如还不生效则查看/data/misc/某个文件夹/prefs/cn.xihan.qdds 这个文件夹权限是否可读,如果不可读手动设置一下，每次修改了配置都需要修改此权限,并应用子文件 权限 都设定为755最佳。还不行就把模块卸载了重新安装，激活后先去把配置调整好，再去上述路径改权限，完事最好清下起点数据，打开就完美了!!!

* 没开启闪屏页却一直显示闪屏页

        这种情况一般是因为本地已经有缓存了,最简单的方法是清除起点的数据,把要开的功能提前开好

* 开启去广告无效

        和上述一致，清数据重启即可

* 目前去青少年模式弹框仅仅只是防止频繁弹，不是完全去掉,我之前测试用隔一会弹一下，开启后仅弹一次
