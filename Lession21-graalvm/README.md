# window 11 环境 graalvm spring boot 编译
1. 下载基于graalvm的jdk
2. 下载native-image 同graalvm版本
 ```bash
   #在线
   gu install native-image
   #离线
   gu install -L xxx.jar
   #查看
   gu list

```
3. 安装Visual Studio 的C++桌面开发环境,以安装到D盘为例
> 配置环境变量 -用户变量配置即可
> PATH  INCLUDE  LIB
>> path添加 D:\Program Files\Microsoft Visual Studio\2022\Community\VC\Tools\MSVC\14.35.32215\bin\Hostx64\x64
>
>> include添加
>> - D:\Program Files\Microsoft Visual Studio\2022\Community\VC\Tools\MSVC\14.35.32215\include
>> - D:\Windows Kits\10\Lib\10.0.22000.0\xxx
> 
>> lib添加
>> - D:\Program Files\Microsoft Visual Studio\2022\Community\VC\Tools\MSVC\14.35.32215\lib\x64
>> - D:\Windows Kits\10\Include\10.0.22000.0\xxx
4. 使用 x64 Native Tools Command Pro的窗口进入到项目下,基于mvn命令打包
```bash 
    mvn -Pnative native:compile
```