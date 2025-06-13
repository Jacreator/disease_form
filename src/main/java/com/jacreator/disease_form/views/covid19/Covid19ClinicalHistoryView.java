package com.jacreator.disease_form.views.covid19;

import java.time.LocalDate;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class Covid19ClinicalHistoryView extends VerticalLayout {
private RadioButtonGroup<String> fever;
    private RadioButtonGroup<String> soreThroat;
    private RadioButtonGroup<String> shortBreath;
    private RadioButtonGroup<String> headache;
    private RadioButtonGroup<String> vomit;
    private RadioButtonGroup<String> tired;
    private RadioButtonGroup<String> dehydrated;
    private RadioButtonGroup<String> nausea;
    private RadioButtonGroup<String> chestPains;
    private RadioButtonGroup<String> diarrhea;
    private RadioButtonGroup<String> lossSmell;
    private RadioButtonGroup<String> lossTaste;
    private RadioButtonGroup<String> redEyes;
    private TextField otherSymptoms;
    private DatePicker dateOfSymptomOnset;

    public Covid19ClinicalHistoryView() {
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
                new FormLayout.ResponsiveStep("800px", 2),
                new FormLayout.ResponsiveStep("1200px", 3)
        );

        fever = createRadioGroup("Fever (≥38 °C) or history of fever");
        soreThroat = createRadioGroup("Sore throat");
        shortBreath = createRadioGroup("Shortness of breath");
        headache = createRadioGroup("Headache");
        vomit = createRadioGroup("Vomiting");
        tired = createRadioGroup("Tiredness");
        dehydrated = createRadioGroup("Dehydration");
        nausea = createRadioGroup("Nausea");
        chestPains = createRadioGroup("Chest pains");
        diarrhea = createRadioGroup("Diarrhea");
        lossSmell = createRadioGroup("Loss of sense of smell");
        lossTaste = createRadioGroup("Loss of sense of taste");
        redEyes = createRadioGroup("Red eyes");

        otherSymptoms = new TextField("Other symptom please specify");
        otherSymptoms.setPlaceholder("Other Symptoms");

        dateOfSymptomOnset = new DatePicker("Date of symptom onset");
        dateOfSymptomOnset.setMax(LocalDate.now());
        dateOfSymptomOnset.setRequired(true);
        dateOfSymptomOnset.setRequiredIndicatorVisible(true);

        form.add(
                fever,
                soreThroat,
                shortBreath,
                headache,
                vomit,
                tired,
                dehydrated,
                nausea,
                chestPains,
                diarrhea,
                lossSmell,
                lossTaste,
                redEyes,
                otherSymptoms,
                dateOfSymptomOnset
        );

        return form;
    }

    private RadioButtonGroup<String> createRadioGroup(String label) {
        RadioButtonGroup<String> group = new RadioButtonGroup<>(label);
        group.setItems("yes", "no", "unknown");
        group.setRequired(true);
        group.setRequiredIndicatorVisible(true);
        return group;
    }
}
