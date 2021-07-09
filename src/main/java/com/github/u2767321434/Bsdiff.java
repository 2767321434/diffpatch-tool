package com.github.u2767321434;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

import java.io.File;


public interface Bsdiff extends Library {

    Bsdiff INSTANCE = (Bsdiff) Native.load(Platform.isWindows()?System.getProperty("java.io.tmpdir")+ File.separator+"lib"+File.separator+"bsdiff-win.dll":System.getProperty("java.io.tmpdir")+File.separator+"lib"+File.separator+"bsdiff.so",Bsdiff.class);
    int bsdiff_main(int argc,String[] args);
}