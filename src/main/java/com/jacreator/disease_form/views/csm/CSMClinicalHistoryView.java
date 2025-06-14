package com.jacreator.disease_form.views.csm;

import java.time.LocalDate;

import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class CSMClinicalHistoryView extends VerticalLayout {
private RadioButtonGroup<String> fever;
    private RadioButtonGroup<String> headache;
    private RadioButtonGroup<String> stiffNeck;
    private RadioButtonGroup<String> soreThroat;
    private RadioButtonGroup<String> pharyngitisTonsilitis;
    private RadioButtonGroup<String> vomitingNausea;
    private RadioButtonGroup<String> musclePain;
    private RadioButtonGroup<String> confusionOrDifficultyConcentrating;
    private CheckboxGroup<String> clinicalPresentation;
    private TextField otherSymptoms;
    private DatePicker dateOfSymptomOnset;

    public CSMClinicalHistoryView() {
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
            new FormLayout.ResponsiveStep("700px", 3));

        fever = createRadioGroup("Fever (>=38C)", false);
        headache = createRadioGroup("Headache", true);
        stiffNeck = createRadioGroup("Stiff neck", true);
        soreThroat = createRadioGroup("Sore throat", true);
        pharyngitisTonsilitis = createRadioGroup("Pharyngitis/Tonsilitis", true);
        vomitingNausea = createRadioGroup("Vomiting or Nausea", true);
        musclePain = createRadioGroup("Muscle pain", true);
        confusionOrDifficultyConcentrating = createRadioGroup("Confusion Or difficulty concentrating", true);

        clinicalPresentation = new CheckboxGroup<>("Clinical presentation");
        clinicalPresentation.setItems(
                "Bacteriemias", "Meningitis", "Pneumonia", "Septic arthritis",
                "Cellulitis", "Pericarditis", "Osteomyelitis", "Purpura fulminans"
        );
        clinicalPresentation.setRequired(true);
        clinicalPresentation.setRequiredIndicatorVisible(true);

        otherSymptoms = new TextField("Other symptom please specify");
        otherSymptoms.setPlaceholder("othersymptoms");

        dateOfSymptomOnset = new DatePicker("Date of symptom onset");
        dateOfSymptomOnset.setMax(LocalDate.now());

        form.add(
                fever,
                headache,
                stiffNeck,
                soreThroat,
                pharyngitisTonsilitis,
                vomitingNausea,
                musclePain,
                confusionOrDifficultyConcentrating,
                clinicalPresentation,
                otherSymptoms,
                dateOfSymptomOnset
        );

        return form;
    }

    private RadioButtonGroup<String> createRadioGroup(String label, boolean required) {
        RadioButtonGroup<String> group = new RadioButtonGroup<>(label);
        group.setItems("yes", "no", "unknown");
        if (required) {
            group.setRequired(true);
            group.setRequiredIndicatorVisible(true);
        }
        return group;
    }
}
