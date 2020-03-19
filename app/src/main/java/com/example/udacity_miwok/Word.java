package com.example.udacity_miwok;

/***
 * @LINK WORD REPRESENT THE VOCABULARY THAT THE USER WANTS TO LEARN
 */

public class Word {
    /**
     * Image Resources for differnt categories
     */
    private final static int NO_IMAGE_PROVIDED = -1;
    /**
     * Default translation for the word
     */
    private String mdefaultTranslation;
    /**
     * Miwok translation for the word
     */
    private String mMiworkTranslation;
    /**
     * Miwok Audio resource for the word
     */
    private int mAudioResource;
    /**
     * Image Resources for differnt categories
     */
    private int mImageResources = NO_IMAGE_PROVIDED;


    public Word(String mdefaultTranslation, String mMiworkTranslation, int mAudioResource) {
        this.mdefaultTranslation = mdefaultTranslation;
        this.mMiworkTranslation = mMiworkTranslation;
        this.mAudioResource = mAudioResource;
    }

    public Word(int mImageResources, String mdefaultTranslation, String mMiworkTranslation, int mAudioResource) {
        this.mImageResources = mImageResources;
        this.mdefaultTranslation = mdefaultTranslation;
        this.mMiworkTranslation = mMiworkTranslation;
        this.mAudioResource = mAudioResource;
    }


    public String getMdefaultTranslation() {
        return mdefaultTranslation;
    }


    public String getmMiworkTranslation() {
        return mMiworkTranslation;
    }

    public int getmImageResources() {
        return mImageResources;
    }

    public boolean hasImage() {
        return mImageResources != NO_IMAGE_PROVIDED;
    }

    public int getmAudioResource() {
        return mAudioResource;
    }
}
