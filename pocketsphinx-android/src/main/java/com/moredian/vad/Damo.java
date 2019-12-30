package com.moredian.vad;

import android.util.Log;

public class Damo {
    static {
        System.loadLibrary("damovadlib-1.18");
    }
    VadEventListener vadEventListener;

    public interface VadEventListener{
        public int onFrame(byte[] frame);
        public int onVadStart();
        public int onVadEnd();
    }

    public void setVadEventListener(VadEventListener l){
        vadEventListener =l;
    }
    private int onFrameCallBack(byte[] frame) {
         if(null !=vadEventListener){
             vadEventListener.onFrame(frame);
         }
        return 0;
    }
    private int onVadStart(){
        if(null != vadEventListener){
            vadEventListener.onVadStart();
        }
        return 0;
    }
    private int onVadEnd(){
        if(null != vadEventListener){
            vadEventListener.onVadEnd();
        }
        return 0;
    }

    public native int startRecordAudio(boolean savePcm);
    public native int stopRecordAudio();
    public native int recordRawData(int duration);   //录音5通道原始数据，供分析用
    public native int setMicMute(boolean on);        //on : true for mute mic, false for unmute mic
}
