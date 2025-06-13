package com.jacreator.disease_form.views.diphtheria;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class DiphtheriaCpostComplicationsView extends VerticalLayout{
private RadioButtonGroup<String> followUpAtWeekOneAfterOnset;
    private RadioButtonGroup<String> followUpAtWeekTwoAfterOnset;
    private RadioButtonGroup<String> followUpAtWeekThreeAfterOnset;
    private RadioButtonGroup<String> followUpAtWeekFourAfterOnset;
    private RadioButtonGroup<String> followUpAtWeekFiveAfterOnset;
    private RadioButtonGroup<String> followUpAtWeekSixAfterOnset;
    private RadioButtonGroup<String> ifYesAnyCpostDiphthericComplication;
    private RadioButtonGroup<String> followUpAtWeekSevenAfterOnset;
    private TextField parentGuardianPhoneNo;
    private TextField comment;

    public DiphtheriaCpostComplicationsView() {
        setWidthFull();
        setPadding(true);
        setSpacing(true);

        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();
        form.setWidthFull();
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("600px", 2),
            new FormLayout.ResponsiveStep("900px", 3)
        );

        followUpAtWeekOneAfterOnset = new RadioButtonGroup<>("Follow up at week 1 after onset?");
        followUpAtWeekOneAfterOnset.setItems("yes", "no");
        followUpAtWeekOneAfterOnset.setRequired(true);
        followUpAtWeekOneAfterOnset.setRequiredIndicatorVisible(true);

        followUpAtWeekTwoAfterOnset = new RadioButtonGroup<>("Follow up at week 2 after onset?");
        followUpAtWeekTwoAfterOnset.setItems("yes", "no");
        followUpAtWeekTwoAfterOnset.setRequired(true);
        followUpAtWeekTwoAfterOnset.setRequiredIndicatorVisible(true);

        followUpAtWeekThreeAfterOnset = new RadioButtonGroup<>("Follow up at week 3 after onset?");
        followUpAtWeekThreeAfterOnset.setItems("yes", "no");
        followUpAtWeekThreeAfterOnset.setRequired(true);
        followUpAtWeekThreeAfterOnset.setRequiredIndicatorVisible(true);

        followUpAtWeekFourAfterOnset = new RadioButtonGroup<>("Follow up at week 4 after onset?");
        followUpAtWeekFourAfterOnset.setItems("yes", "no");
        followUpAtWeekFourAfterOnset.setRequired(true);
        followUpAtWeekFourAfterOnset.setRequiredIndicatorVisible(true);

        followUpAtWeekFiveAfterOnset = new RadioButtonGroup<>("Follow up at week 5 after onset?");
        followUpAtWeekFiveAfterOnset.setItems("yes", "no");
        followUpAtWeekFiveAfterOnset.setRequired(true);
        followUpAtWeekFiveAfterOnset.setRequiredIndicatorVisible(true);

        followUpAtWeekSixAfterOnset = new RadioButtonGroup<>("Follow up at week 6 after onset?");
        followUpAtWeekSixAfterOnset.setItems("yes", "no");
        followUpAtWeekSixAfterOnset.setRequired(true);
        followUpAtWeekSixAfterOnset.setRequiredIndicatorVisible(true);

        // Conditional field - initially hidden
        ifYesAnyCpostDiphthericComplication = new RadioButtonGroup<>("If yes, is there any cpost diphtheric complication?");
        ifYesAnyCpostDiphthericComplication.setItems("yes", "no");
        ifYesAnyCpostDiphthericComplication.setVisible(false);
        ifYesAnyCpostDiphthericComplication.setRequired(false);

        // Add listener to show/hide conditional field
        followUpAtWeekSixAfterOnset.addValueChangeListener(e -> {
            boolean showComplication = "yes".equals(e.getValue());
            ifYesAnyCpostDiphthericComplication.setVisible(showComplication);
            ifYesAnyCpostDiphthericComplication.setRequired(showComplication);
            ifYesAnyCpostDiphthericComplication.setRequiredIndicatorVisible(showComplication);
            
            if (!showComplication) {
                ifYesAnyCpostDiphthericComplication.clear();
            }
        });

        followUpAtWeekSevenAfterOnset = new RadioButtonGroup<>("Follow up at week 7 after onset?");
        followUpAtWeekSevenAfterOnset.setItems("yes", "no");
        followUpAtWeekSevenAfterOnset.setRequired(true);
        followUpAtWeekSevenAfterOnset.setRequiredIndicatorVisible(true);

        parentGuardianPhoneNo = new TextField("Parent/guardian phone No");
        parentGuardianPhoneNo.setRequired(true);
        parentGuardianPhoneNo.setRequiredIndicatorVisible(true);

        comment = new TextField("Comment");
        comment.setRequired(true);
        comment.setRequiredIndicatorVisible(true);

        form.add(
            followUpAtWeekOneAfterOnset,
            followUpAtWeekTwoAfterOnset,
            followUpAtWeekThreeAfterOnset,
            followUpAtWeekFourAfterOnset,
            followUpAtWeekFiveAfterOnset,
            followUpAtWeekSixAfterOnset,
            ifYesAnyCpostDiphthericComplication,
            followUpAtWeekSevenAfterOnset,
            parentGuardianPhoneNo,
            comment
        );

        return form;
    }
}
