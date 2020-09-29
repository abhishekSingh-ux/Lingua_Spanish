package com.example.miwok;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId=NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED=-1;
    private int mAudioResourceId;

    //constructor for creating new object instances
    public Word(String defaultTranslation, String miwokTranslation, int songResourceId){
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mAudioResourceId=songResourceId;
    }
    //constructor for creating new object instances
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int songResourceId){
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mImageResourceId= imageResourceId;
        mAudioResourceId=songResourceId;
    }

    //getter method for the default Trnaslation
    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    //getter method for the miwok Trnaslation
    public String getMiwokTranslation()
    {
        return  mMiwokTranslation;
    }

    //getter method for image resources
    public int getImageResource()
    {
        return  mImageResourceId;
    }
    /*
    * Returns whether there is an image or not
    * */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getmAudioResourceId(){ return mAudioResourceId;}

}
