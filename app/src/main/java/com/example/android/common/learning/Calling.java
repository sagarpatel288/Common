package com.example.android.common.learning;

class Calling {

    private String staticOfEnum = LearnEnum.staticInEnum;
    private LearnEnum fromLearnEnumType1 = LearnEnum.TYPE1;
    private String fromLearnEnumString = fromLearnEnumType1.getSTRING_VALUE();

}
