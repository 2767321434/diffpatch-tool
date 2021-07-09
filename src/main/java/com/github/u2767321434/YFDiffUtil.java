package com.github.u2767321434;

import com.sun.jna.Platform;

public class YFDiffUtil {
    static {
        if(Platform.isWindows()){
            LibLoader.loadLib("bsdiff-win.dll");
            LibLoader.loadLib("bspatch-win.dll");
        }else{
            LibLoader.loadLib("bsdiff.so");
            LibLoader.loadLib("bspatch.so");
        }
    }
    public static boolean makePatch(String oldfile,String newfile,String patchfile) throws Exception {
        if(isNotEmpty(oldfile)&&isNotEmpty(newfile)&&isNotEmpty(patchfile)){
            String[] args=new String[]{"",oldfile,newfile,patchfile};
            try {
                Bsdiff.INSTANCE.bsdiff_main(args.length, args);
            }catch (Exception e){
                throw e;
            }
        }else{
            throw new Exception("参数不能为空");
        }
        return true;
    }
    public static boolean mergePatch(String oldfile,String newfile,String patchfile) throws Exception {
        if(isNotEmpty(oldfile)&&isNotEmpty(newfile)&&isNotEmpty(patchfile)){
            String[] args=new String[]{"",oldfile,newfile,patchfile};
            try {
                Bspatch.INSTANCE.bspatch_main(args.length, args);
            }catch (Exception e){
                throw e;
            }
        }else{
            throw new Exception("参数不能为空");
        }
        return true;
    }
    private static boolean isNotEmpty(String str){
        if(str!=null){
            if(str.length()>0){
                return !"".equals(str.trim());
            }
        }
        return false;
    }
}
