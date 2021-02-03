package com.meinc.qanda.data

import com.meinc.qanda.models.QAModel

object QAData {
    var qaCpp: ArrayList<QAModel> = arrayListOf(
        QAModel(
            "Which of the following statements is incorrect?",
            "Variables having scope may not be visible.",
            "Variables having visibility may not have any scope.",
            "Variable has scope & visibility.",
            "None",
            30, 3
        ),
        QAModel(
            "Which of the following keywords can’t appear inside a class definition?",
            "Field",
            "Virtual",
            "Static",
            "Template",
            30,
            4
        ),
        QAModel(
            "Why is a class useful in programming?",
            "can closely model objects in the real world.",
            "permit data to be hidden from other classes.",
            "bring together all aspects of an entity in one place.",
            "are removed from memory when not in use.", 30,
            2
        ),
        QAModel(
            "Which of the following isn’t supported in C++ language?",
            "Inheritance",
            "Namespaces",
            "Polymorphism",
            "Reflection", 30,
            4
        )
    )
    var qaUXUI: ArrayList<QAModel> = arrayListOf(
        QAModel(
            "Which of the following is true of the information scent for a webpage?",
            "It does not vary from user to user.",
            "It stays the same regardless of the user’s goal.",
            "It does not depend on label of the link to that page.",
            "It represents an estimate of how valuable that user will find the page.",
            30,
            4
        ),

        QAModel(
            "Compared with emails without animated GIFs, emails with animated GIFS are perceived by users:",
            "As more trustworthy",
            "Less positively",
            "As more valuable",
            "As less dull",
            30,
            2
        ),

        QAModel(
            "Dark mode has been shown to:",
            "Support glanceable reading in people with normal vison",
            "Make users with normal vision be less fatigued",
            "Decrease visual acuity in people with normal vision",
            "Decrease reading rates in people with visual impairments such as cataract",
            30,
            3
        )

    )
}