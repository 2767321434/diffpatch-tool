package com.github.u2767321434;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

import java.io.File;

public interface Bspatch extends Library {
    Bspatch INSTANCE = (Bspatch) Native.load(Platform.isWindows()?System.getProperty("java.io.tmpdir")+ File.separator+"lib"+File.separator+"bspatch-win.dll":System.getProperty("java.io.tmpdir")+File.separator+"lib"+File.separator+"bspatch.so",Bspatch.class);
    int bspatch_main(int argc,String[] args);
}
