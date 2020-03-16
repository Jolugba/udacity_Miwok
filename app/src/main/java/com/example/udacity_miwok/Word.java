package com.example.udacity_miwok;

/***
 * @LINK WORD REPRESENT THE VOCABULARY THAT THE USER WANTS TO LEARN
 */

public class Word {
    /**Default translation for the word*/
    private String mdefaultTranslation;

    /**Miwok translation for the word*/
    private String mMiworkTranslation;

    /**Image Resources for differnt categories*/
    private int mImageResources=NO_IMAGE_PROVIDED;

    /**Image Resources for differnt categories*/
    private final static int NO_IMAGE_PROVIDED=-1 ;


    public Word(String mdefaultTranslation, String mMiworkTranslation) {
        this.mdefaultTranslation = mdefaultTranslation;
        this.mMiworkTranslation = mMiworkTranslation;
    }

    public Word(int mImageResources, String mdefaultTranslation, String mMiworkTranslation) {
        this.mImageResources=mImageResources;
        this.mdefaultTranslation = mdefaultTranslation;
        this.mMiworkTranslation = mMiworkTranslation;}



    public String getMdefaultTranslation() {
        return mdefaultTranslation;
    }



    public String getmMiworkTranslation() {
        return mMiworkTranslation;
    }

    public int getmImageResources() {
        return mImageResources;


    }
    public boolean hasImage(){
        return mImageResources!=NO_IMAGE_PROVIDED;
    }
}
