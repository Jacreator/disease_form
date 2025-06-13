package com.jacreator.disease_form.views.measles;

import java.time.LocalDate;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class MeaslesClinicalHistoryView extends VerticalLayout{
// State for conditional fields
    private String historyOfHospitalizationValue = null;
    private String outcomeValue = null;

    // Form fields that need to be shown/hidden
    private TextField inpatientNameOfHospital;
    private DatePicker dateOfHospitalization;
    private DatePicker dateDeath;

    public MeaslesClinicalHistoryView() {
        setWidthFull();
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        String[] yesNoUnknown = {"Yes", "No", "Unknown"};

        // Fever
        RadioButtonGroup<String> fever = new RadioButtonGroup<>();
        fever.setLabel("Fever");
        fever.setItems(yesNoUnknown);
        fever.setRequired(true);

        // Rash
        RadioButtonGroup<String> rash = new RadioButtonGroup<>();
        rash.setLabel("Rash");
        rash.setItems(yesNoUnknown);
        rash.setRequired(true);

        // Cough
        RadioButtonGroup<String> cough = new RadioButtonGroup<>();
        cough.setLabel("Cough");
        cough.setItems(yesNoUnknown);
        cough.setRequired(true);

        // Runny nose (Catarrh)
        RadioButtonGroup<String> catarrh = new RadioButtonGroup<>();
        catarrh.setLabel("Runny nose (Catarrh)");
        catarrh.setItems(yesNoUnknown);
        catarrh.setRequired(true);

        // Red eyes (Conjunctivitis)
        RadioButtonGroup<String> conjunctivitis = new RadioButtonGroup<>();
        conjunctivitis.setLabel("Red eyes (Conjunctivitis)");
        conjunctivitis.setItems(yesNoUnknown);
        conjunctivitis.setRequired(true);

        // Joint swelling/pain
        RadioButtonGroup<String> jointSwellingPain = new RadioButtonGroup<>();
        jointSwellingPain.setLabel("Joint swelling/pain");
        jointSwellingPain.setItems(yesNoUnknown);
        jointSwellingPain.setRequired(true);

        // Swollen lymph nodes behind Ears
        RadioButtonGroup<String> swollenLymphNodesBehindEars = new RadioButtonGroup<>();
        swollenLymphNodesBehindEars.setLabel("Swollen lymph nodes behind Ears");
        swollenLymphNodesBehindEars.setItems(yesNoUnknown);
        swollenLymphNodesBehindEars.setRequired(true);

        // History of hospitalization
        RadioButtonGroup<String> historyOfHospitalization = new RadioButtonGroup<>();
        historyOfHospitalization.setLabel("History of hospitalization");
        historyOfHospitalization.setItems("In patient", "Out patient");
        historyOfHospitalization.setRequired(true);

        // Name of hospital (conditional)
        inpatientNameOfHospital = new TextField("Name of hospital");
        inpatientNameOfHospital.setPlaceholder("Name of hospital");
        inpatientNameOfHospital.setVisible(false);

        // Date of hospitalization (conditional)
        dateOfHospitalization = new DatePicker("Date of hospitalization");
        dateOfHospitalization.setMax(LocalDate.now());
        dateOfHospitalization.setRequired(true);
        dateOfHospitalization.setVisible(false);

        // Outcome
        RadioButtonGroup<String> outcome = new RadioButtonGroup<>();
        outcome.setLabel("Outcome");
        outcome.setItems("Alive", "Dead", "Unknown");
        outcome.setRequired(true);

        // Date of death (conditional)
        dateDeath = new DatePicker("Date of death");
        dateDeath.setMax(LocalDate.now());
        dateDeath.setRequired(true);
        dateDeath.setVisible(false);

        // Others (Specify)
        TextField otherSymptoms = new TextField("Others (Specify)");
        otherSymptoms.setPlaceholder("Specify other symptoms");

        // Date of symptom onset
        DatePicker dateSymptomOnset = new DatePicker("Date of symptom onset");
        dateSymptomOnset.setMax(LocalDate.now());
        dateSymptomOnset.setRequired(true);

        // Responsive steps
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("800px", 2),
            new FormLayout.ResponsiveStep("1200px", 3)
        );

        // Add all fields to the form
        form.add(
            fever,
            rash,
            cough,
            catarrh,
            conjunctivitis,
            jointSwellingPain,
            swollenLymphNodesBehindEars,
            historyOfHospitalization,
            inpatientNameOfHospital,
            dateOfHospitalization,
            outcome,
            dateDeath,
            otherSymptoms,
            dateSymptomOnset
        );

        // Conditional logic for historyOfHospitalization
        historyOfHospitalization.addValueChangeListener(event -> {
            boolean show = "In patient".equals(event.getValue());
            inpatientNameOfHospital.setVisible(show);
            dateOfHospitalization.setVisible(show);
        });

        // Conditional logic for outcome
        outcome.addValueChangeListener(event -> {
            boolean show = "Dead".equals(event.getValue());
            dateDeath.setVisible(show);
        });

        return form;
    }
}
