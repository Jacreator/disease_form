package com.jacreator.disease_form.views.influenza;

import java.time.LocalDate;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class InfluenzaClinicalHistoryView extends VerticalLayout {
// State for conditional fields
    private RadioButtonGroup<String> feverGroup;
    private DatePicker dateFeverOnset;

    public InfluenzaClinicalHistoryView() {
        setWidthFull();
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Fever
        feverGroup = new RadioButtonGroup<>();
        feverGroup.setLabel("Fever");
        feverGroup.setItems("Yes", "No", "Unknown");
        feverGroup.setRequired(true);

        // Date of Fever Onset (conditional)
        dateFeverOnset = new DatePicker("Date Of Fever Onset");
        dateFeverOnset.setMax(LocalDate.now());
        dateFeverOnset.setRequired(true);
        dateFeverOnset.setVisible(false);

        // Show/hide dateFeverOnset based on fever selection
        feverGroup.addValueChangeListener(event -> {
            boolean show = "Yes".equals(event.getValue());
            dateFeverOnset.setVisible(show);
        });

        // Cough
        RadioButtonGroup<String> coughGroup = new RadioButtonGroup<>();
        coughGroup.setLabel("Cough?");
        coughGroup.setItems("Yes", "No", "Unknown");
        coughGroup.setRequired(true);

        // Difficulty Breathing
        RadioButtonGroup<String> difficultyBreathingGroup = new RadioButtonGroup<>();
        difficultyBreathingGroup.setLabel("Difficulty Breathing?");
        difficultyBreathingGroup.setItems("Yes", "No", "Unknown");
        difficultyBreathingGroup.setRequired(true);

        // Chest Indrawing
        RadioButtonGroup<String> chestIndrawingGroup = new RadioButtonGroup<>();
        chestIndrawingGroup.setLabel("Chest Indrawing?");
        chestIndrawingGroup.setItems("Yes", "No", "Unknown");
        chestIndrawingGroup.setRequired(true);

        // Chest Pain
        RadioButtonGroup<String> chestPainGroup = new RadioButtonGroup<>();
        chestPainGroup.setLabel("Chest Pain");
        chestPainGroup.setItems("Yes", "No", "Unknown");
        chestPainGroup.setRequired(true);

        // Sore Throat
        RadioButtonGroup<String> soreThroatGroup = new RadioButtonGroup<>();
        soreThroatGroup.setLabel("Sore Throat?");
        soreThroatGroup.setItems("Yes", "No", "Unknown");
        soreThroatGroup.setRequired(true);

        // Vomiting or Nausea
        RadioButtonGroup<String> vomitingNauseaGroup = new RadioButtonGroup<>();
        vomitingNauseaGroup.setLabel("Vomiting or Nausea?");
        vomitingNauseaGroup.setItems("Yes", "No", "Unknown");
        vomitingNauseaGroup.setRequired(true);

        // Diarrhea
        RadioButtonGroup<String> diarrheaGroup = new RadioButtonGroup<>();
        diarrheaGroup.setLabel("Diarrhea");
        diarrheaGroup.setItems("Yes", "No", "Unknown");
        diarrheaGroup.setRequired(true);

        // Others: (specify)
        TextField otherSpecify = new TextField("Others: (specify)");
        otherSpecify.setPlaceholder("Enter other symptoms");

        // Date Of Symptom Onset
        DatePicker dateOfOnset = new DatePicker("Date Of Symptom Onset");
        dateOfOnset.setMax(LocalDate.now());
        dateOfOnset.setRequired(true);

        // Patient vaccinated against Flu?
        RadioButtonGroup<String> patientVaccineFluGroup = new RadioButtonGroup<>();
        patientVaccineFluGroup.setLabel("Patient vaccinated against Flu?");
        patientVaccineFluGroup.setItems("Yes", "No", "Unknown");
        patientVaccineFluGroup.setRequired(true);

        // Currently taking antiviral medicine?
        RadioButtonGroup<String> patientTakeAntiviralGroup = new RadioButtonGroup<>();
        patientTakeAntiviralGroup.setLabel("Currently taking antiviral medicine?");
        patientTakeAntiviralGroup.setItems("Yes", "No", "Unknown");
        patientTakeAntiviralGroup.setRequired(true);

        // Responsive steps
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("800px", 2),
            new FormLayout.ResponsiveStep("1200px", 3)
        );

        // Add all fields to the form
        form.add(
            feverGroup,
            dateFeverOnset,
            coughGroup,
            difficultyBreathingGroup,
            chestIndrawingGroup,
            chestPainGroup,
            soreThroatGroup,
            vomitingNauseaGroup,
            diarrheaGroup,
            otherSpecify,
            dateOfOnset,
            patientVaccineFluGroup,
            patientTakeAntiviralGroup
        );

        return form;
    }
}
