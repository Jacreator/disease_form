package com.jacreator.disease_form.views.influenza;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class InfluenzaEpidemiologicalView extends VerticalLayout {
public InfluenzaEpidemiologicalView() {
        setWidthFull();
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // All questions as RadioButtonGroups
        RadioButtonGroup<String> exposureWithSickBirdPoultry = new RadioButtonGroup<>();
        exposureWithSickBirdPoultry.setLabel("Exposure/contact in last 7 days with sick or dead bird or poultry?");
        exposureWithSickBirdPoultry.setItems("Yes", "No", "Unknown");
        exposureWithSickBirdPoultry.setRequired(true);

        RadioButtonGroup<String> exposureWithRespiratoryIllness = new RadioButtonGroup<>();
        exposureWithRespiratoryIllness.setLabel("Exposure/contact in last 7 days with family member/ any person with severe respiratory illness?");
        exposureWithRespiratoryIllness.setItems("Yes", "No", "Unknown");
        exposureWithRespiratoryIllness.setRequired(true);

        RadioButtonGroup<String> exposureWithAreaAvianFlu = new RadioButtonGroup<>();
        exposureWithAreaAvianFlu.setLabel("Exposure/contact in last 7 days with recent travel to area with avian flu/Novel Influenza?");
        exposureWithAreaAvianFlu.setItems("Yes", "No", "Unknown");
        exposureWithAreaAvianFlu.setRequired(true);

        RadioButtonGroup<String> exposureWithRawUndercookedPoultry = new RadioButtonGroup<>();
        exposureWithRawUndercookedPoultry.setLabel("Exposure/contact in last 7 days with eating raw or undercooked poultry?");
        exposureWithRawUndercookedPoultry.setItems("Yes", "No", "Unknown");
        exposureWithRawUndercookedPoultry.setRequired(true);

        RadioButtonGroup<String> exposureWithSampleOfSuspectedAvianFlu = new RadioButtonGroup<>();
        exposureWithSampleOfSuspectedAvianFlu.setLabel("Exposure/contact in last 7 days with sample from suspected cases of Avian flu/Novel Influenza?");
        exposureWithSampleOfSuspectedAvianFlu.setItems("Yes", "No", "Unknown");
        exposureWithSampleOfSuspectedAvianFlu.setRequired(true);

        RadioButtonGroup<String> heartDisease = new RadioButtonGroup<>();
        heartDisease.setLabel("Heart Disease");
        heartDisease.setItems("Yes", "No", "Unknown");
        heartDisease.setRequired(true);

        RadioButtonGroup<String> chronicShortnessOfBreath = new RadioButtonGroup<>();
        chronicShortnessOfBreath.setLabel("Chronic Shortness of Breath");
        chronicShortnessOfBreath.setItems("Yes", "No", "Unknown");
        chronicShortnessOfBreath.setRequired(true);

        RadioButtonGroup<String> asthma = new RadioButtonGroup<>();
        asthma.setLabel("Asthma");
        asthma.setItems("Yes", "No", "Unknown");
        asthma.setRequired(true);

        RadioButtonGroup<String> cancer = new RadioButtonGroup<>();
        cancer.setLabel("Cancer");
        cancer.setItems("Yes", "No", "Unknown");
        cancer.setRequired(true);

        RadioButtonGroup<String> smoking = new RadioButtonGroup<>();
        smoking.setLabel("Smoking?");
        smoking.setItems("Yes", "No", "Unknown");
        smoking.setRequired(true);

        RadioButtonGroup<String> diabetes = new RadioButtonGroup<>();
        diabetes.setLabel("Diabetes");
        diabetes.setItems("Yes", "No", "Unknown");
        diabetes.setRequired(true);

        RadioButtonGroup<String> chronicLiverDisease = new RadioButtonGroup<>();
        chronicLiverDisease.setLabel("Chronic Liver Disease");
        chronicLiverDisease.setItems("Yes", "No", "Unknown");
        chronicLiverDisease.setRequired(true);

        RadioButtonGroup<String> chronicKidneyDisease = new RadioButtonGroup<>();
        chronicKidneyDisease.setLabel("Chronic Kidney Disease");
        chronicKidneyDisease.setItems("Yes", "No", "Unknown");
        chronicKidneyDisease.setRequired(true);

        RadioButtonGroup<String> hivAidStatus = new RadioButtonGroup<>();
        hivAidStatus.setLabel("HIV/AIDS Status");
        hivAidStatus.setItems("Positive", "Negative", "Unknown");
        hivAidStatus.setRequired(true);

        // Responsive steps
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("800px", 2)
        );

        // Add all fields to the form
        form.add(
            exposureWithSickBirdPoultry,
            exposureWithRespiratoryIllness,
            exposureWithAreaAvianFlu,
            exposureWithRawUndercookedPoultry,
            exposureWithSampleOfSuspectedAvianFlu,
            heartDisease,
            chronicShortnessOfBreath,
            asthma,
            cancer,
            smoking,
            diabetes,
            chronicLiverDisease,
            chronicKidneyDisease,
            hivAidStatus
        );

        return form;
    }
}
