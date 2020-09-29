package com.example.miwok;

public class ReportCard {
    private String mName;
    private char mEnglishGrade;
    private String mChemistryGrade;
    private int mMathGrade;

    public ReportCard(String name, char englishGrade, String chemistryGrade, int mathGrade){
        this.mName=name;
        this.mEnglishGrade= englishGrade;
        this.mChemistryGrade= chemistryGrade;
        this.mMathGrade= mathGrade;
    }
    public String getName(){
        return mName;
    }
    public void setName(String name){
        mName=name;
    }

    public char getEnglishGrade(){
        return mEnglishGrade;
    }
    public void setmEnglishGrade(char englishGrade){
        mEnglishGrade=englishGrade;
    }

    public int getmMathGrade(){
        return mMathGrade;
    }
    public void setmMathGrade(int mathGrade){
        mMathGrade=mathGrade;
    }

    public String getmChemistryGrade(){
        return mChemistryGrade;
    }
    public void setmChemistryGrade(String chemistryGrade){
        mChemistryGrade=chemistryGrade;
    }

    @Override
    public String toString(){
        String newString= "Name: "+ mName+"; "+ "English Grade: "+ mEnglishGrade+ "; "+"Chemistry Grade: "+
                mChemistryGrade+ "; "+"Math Grade: "+ mMathGrade+"; ";
        return newString;
    }

}
