package com.example.muskanchotrani.quiz;

import static android.R.transition.move;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Muskan Chotrani on 01-07-2017.
 */

public class questons {
    private String ques[] = {
            "Find the answer that best matches the stem pair in the analogy.",
            "Which one of the sets of letters below can be arranged into a five letter English word.",
            "Find the answer that best completes the analogy.",
            "Which number should come next in this series?",
            "If 10 people can do a piece of work in 5 days, working 2 hours a day, how long will 2 people take to do the same work, working 5 hours a day?",
            "Which number should come next in this series?",
            "Which word is a misfit in the following groups?",
            "At a conference, 12 members shook hands with each other before and after the meeting. How many total number of hand shakes occurred?",
            "The day after the day after tomorrow is four days before Monday. What day is it today?",
            "A fisherman has 5 fishes (namely A, B, C,D, E) each having a different weight.Which of the following is the lightest?",
            "6121135 is to flame as 21215120 is to ?",
            "Forest is to tree as tree is to ?",
            "Which of the following can be arranged into a 5-letter English word?",
            "Which conclusion can be drawn with absolute certainty from these two statements?",
            "Marathon is to race as hibernation is to",
            "Which word does NOT belong with the others?",
            "Look at this series: 7, 10, 8, 11, 9, 12, ... What number should come next?",
            "If TRANSFER is coded as RTNAFSRE, then ELEPHANT would be coded as ",
            "Only gentlemen can become members of the club. Many of the members of the club are officers. Some of the officers have been invited for dinner.",
            "Pointing to a man in a photograph, a woman said, \"His brother's father is the only son of my grandfather.\" How is the woman related to the man in the photograph?",
            "Pointing to Manju, Raju said, “The son of her only brother is the brother of my wife”. How is Manju related to Raju?",
            "How is Radha’s mother’s mother’s daughter-in-law’s daughter related to Radha?",
            " Mr.Ramu’s mother’s father-in-law’s only son’s only daughter’s son is Chetan. How is Ramu related to Chetan?",
            "In a certain code language if the word ‘MUSEUM’ is coded as ‘LSPAPG’, then how will the word ‘PALACE’ be coded in that language?",
            "In a certain code language, ‘kew xas huma deko’ means ‘she is eating apples’; ‘kew tepo qua’ means ‘she sells toys’ and ‘sul lim deko’ means ‘I like apples’. Which word in that language means ‘she’ and‘apples’?",
            "Dungeon: Confinement:: Asylum : ?",
            "Insomnia is to Lead as Minamata is to……",
            "The last day of a century cannot be :",
            "By how many degrees does the minute hand move in the same time, in which the hour hand move by 18 degree ?",
            "What is the angle between the two hands of a clock when the time shown by the clock is 5.30 p.m. ?",
            " A software engineer has the capability of thinking 100 lines of code in five minutes and can type 100 lines of code in 10 minutes. He takes a break for five minutes after every ten minutes. How many lines of codes will he complete typing after an hour? ",
            "A monkey starts climbing up a tree 20ft. tall. Each hour, it hops 3ft. and slips back 2ft. How much time would it take the monkey to reach the top?",
            " If a light flashes every 6 seconds, how many times will it flash in ¾ of an hour?",
            "One evening, two friends Riya and Priya were talking to each other, with their backs towards each other, sitting in a park. If Riya’s shadow was exactly to the left of her, then which direction was Priya facing?",
            "After walking 6 kms, I turned right and travelled a distance of 2 kms, then turned left and covered a distance of 10 km. In the end I was moving towards the north. From which direction did I start my journey?",
    };
    private String res [] = {
            "SEDATIVE :: DROWSINESS"," ","FRUGAL : MISERLY :: RASH : ?","10, 17, 26, 37, ?"," ",
            "10, 17, 26, 37, ?"," "," "," ","A weighs twice as much as B,B weighs four and a half times as much as C,C weighs half as much as D,D weighs half as much as E,E weighs less than A but more than C.",
            " "," "," ","All cats have fleas. Fleas are red."," ",
            " "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ",
    };
    private String options[][] ={
            {"epidemic : contagiousness","laxative : drug","anesthetic : numbness","therapy : psychosis",},
            {"a t r u n","t e c a r","m o h a t","e t l r n",},
            {"arrogant","profligate","spendthrift","foolhardy",},
            {"46","52","50","56",},
            {"8","10","5","12",},
            {"46","52","50","56",},
            {"Tibetan","Carstensz","Denali","Elbrus",},
            {"100","132","145","144",},
            {"Monday","Tuesday","Wednesday","Sunday",},
            {"A","B","C","D",},
            {"voice","bald","caste","bloat",},
            {"plant","leaf","branch","fruits",},
            {"H R G S T","R I L S A","T O S M T","W Q R G S",},
            {"All cats have red fleas","All fleas are on cats","Cats can sometimes have black fleas","Dogs never have red fleas",},
            {"isolate","dream","winter","sleep",},
            {"inch","meter","ounce","yard",},
            {"10","7","12","13",},
            {"LEPEHATN","LEPEAHTN","LEEPAHTN","LEPEAHNT",},
            {"All the members of the club have been invited for dinner","Some of the officers are not gentlemen","All gentlemen are members of the club","Only gentlemen have been invited for dinner",},
            {"Sister","Aunt","Grandmother","Daughter",},
            {"Mother’s sister","Grandmother","Mother-in-law","Sister of father-in-law",},
            {"Sister","Mother","Cousin","Aunt",},
            {"Uncle","Nephew","Niece","Father",},
            {"OYIWXY","OYIXYW","IYXYWO","YXWYOI",},
            {"xas and deko","xas and kew","kew and deko","kew and xas",},
            {"Refuge","Mercy","Truancy","Remorse",},
            {"Tobacco","Mercury","Alcohol","Chromium",},
            {"Monday","Wednesday","Friday","Saturday",},
            {"168 degree","216 degree","196 degree","276 degree",},
            {"0 degree","3 degree","15 degree","5 degree",},
            {"220","250","150","200",},
            {"21 hours","12 hours","18 hours","15 hours",},
            {"450","451","350","425",},
            {"North-East","North","East","South",},
            {"North","South","South-West","North-East",},

    };
    private String correct_options[]={
            "anesthetic : numbness","t e c a r","foolhardy","50","10",
            "52","Tibetan","132","Monday","C",
            "bloat","leaf","R I L S A","All cats have red fleas","sleep",
            "ounce","10","LEPEAHTN","Only gentlemen have been invited for dinner","Sister","Sister of father-in-law","Cousin","Uncle","OYIWXY",
            "kew and deko","Refuge","Mercury","Saturday","216 degree","15 degree","250","18 hours","451","North","South",

    };
    public String getQuestion(int a)
    {
        String question = ques[a];
        return question;
    }
    public String getResource(int a)
    {
        String reso = res[a];
        return reso;
    }
    public String getChoice1(int a)
    {
        String choice = options[a][0];
        return choice;
    }
    public String getChoice2(int a)
    {
        String choice = options[a][1];
        return choice;
    }
    public String getChoice3(int a)
    {
        String choice = options[a][2];
        return choice;
    }
    public String getChoice4(int a)
    {
        String choice = options[a][3];
        return choice;
    }
    public String getCorrectAnswer(int a)
    {
        String choice = correct_options[a];
        return choice;
    }
}
