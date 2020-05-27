Minimal Java app demonstrating inability to access Documents, Desktop, and Downloads
dirs in macOS 10.15 "Catalina" from Java JFileChooser when bundled as an app whose
CFBundleExecutable stub is a script.

These dirs are accessible through FileDialog, which appears to use the native macOS chooser.
The expected system dialog "CatalinaFileChooserAccessTest.app would like to access the 
[folder name] folder" does not appear in JFileChooser, thus access cannot be granted.

![demo GIF](https://github.com/sorghumking/catalinaFileChooserAccessTest/blob/master/img/chooserAccessDemo.gif)

These dirs are accessible from both dialogs when built and run locally.

When the CFBundleExecutable stub is a compiled binary, prompts to allow access to those dirs appear as expected.

The problem manifests only when packaged as an app bundle whose CFBundleExecutable is a script.

Tested in Java 8 and 11.

## Usage

### Install Ant
- Download Ant 1.10.7 at [https://ant.apache.org/bindownload.cgi]
- Extract Ant, add [Ant root]/bin dir to your PATH if desired.

### Build app bundle with script stub
- Download jarbundler-core-3.3.0.jar at [https://github.com/UltraMixer/JarBundler/releases]
- Move jarbundler-core-3.3.0.jar to the [Ant root]/lib dir.
- In CatalinaFileChooserAccessTest dir, run `ant jarbundler` to create an app bundle in the build_jarbundler dir.
- Run non-bundled via `java`:
  * `cd classes`
  * `java org.csdco.CatalinaFileChooserAccessTest`
  * Documents/Desktop/Downloads contents are accessible in JFileChooser.
- Double-click to launch CatalinaFileChooserAccessTest.app. Documents/Desktop/Downloads contents are *not* accessible in JFileChooser.

### Build app bundle with compiled binary stub
- Download appbundler-1.0ea.jar at [https://github.com/rlabduke/javadev/tree/master/lib/appbundler]
- Move appbundler-1.0ea.jar to the [Ant root]/lib dir.
- In CatalinaFileChooserAccessTest dir, run `ant appbundler` to create an app bundle in the build_appbundler dir.
- Double-click to launch CatalinaFileChooserAccessTest.app. Documents/Desktop/Downloads contents *are* accessible in JFileChooser.
after expected "CatalinaFileChooserAccessTest.app would like to access the [folder name] folder" prompts.
