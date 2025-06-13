package com.jacreator.disease_form.views.lassa_fever;

import java.time.LocalDate;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class LassaFeverClinicalHistoryView extends VerticalLayout {
public LassaFeverClinicalHistoryView() {
        setWidthFull();
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        String[] yesNoUnknown = {"Yes", "No", "Unknown"};

        // Fever (≥38 °C)
        RadioButtonGroup<String> fever = new RadioButtonGroup<>();
        fever.setLabel("Fever (≥38 °C)");
        fever.setItems(yesNoUnknown);
        fever.setRequired(true);

        // General weakness
        RadioButtonGroup<String> generalWeakness = new RadioButtonGroup<>();
        generalWeakness.setLabel("General weakness");
        generalWeakness.setItems(yesNoUnknown);
        generalWeakness.setRequired(true);

        // Malaise
        RadioButtonGroup<String> malaise = new RadioButtonGroup<>();
        malaise.setLabel("Malaise");
        malaise.setItems(yesNoUnknown);
        malaise.setRequired(true);

        // Sore throat
        RadioButtonGroup<String> soreThroat = new RadioButtonGroup<>();
        soreThroat.setLabel("Sore throat");
        soreThroat.setItems(yesNoUnknown);
        soreThroat.setRequired(true);

        // Chest pain
        RadioButtonGroup<String> chestPain = new RadioButtonGroup<>();
        chestPain.setLabel("Chest pain");
        chestPain.setItems(yesNoUnknown);
        chestPain.setRequired(true);

        // Vomitting or nausea
        RadioButtonGroup<String> vomittingNausea = new RadioButtonGroup<>();
        vomittingNausea.setLabel("Vomitting or nausea");
        vomittingNausea.setItems(yesNoUnknown);
        vomittingNausea.setRequired(true);

        // Cough
        RadioButtonGroup<String> cough = new RadioButtonGroup<>();
        cough.setLabel("Cough");
        cough.setItems(yesNoUnknown);
        cough.setRequired(true);

        // Oral ulcer
        RadioButtonGroup<String> oralUlcer = new RadioButtonGroup<>();
        oralUlcer.setLabel("Oral ulcer");
        oralUlcer.setItems(yesNoUnknown);
        oralUlcer.setRequired(true);

        // Muscle pain
        RadioButtonGroup<String> musclePain = new RadioButtonGroup<>();
        musclePain.setLabel("Muscle pain");
        musclePain.setItems(yesNoUnknown);
        musclePain.setRequired(true);

        // Abdominal cramps
        RadioButtonGroup<String> abdominalCramps = new RadioButtonGroup<>();
        abdominalCramps.setLabel("Abdominal cramps");
        abdominalCramps.setItems(yesNoUnknown);
        abdominalCramps.setRequired(true);

        // Headache
        RadioButtonGroup<String> headache = new RadioButtonGroup<>();
        headache.setLabel("Headache");
        headache.setItems(yesNoUnknown);
        headache.setRequired(true);

        // Unexplained bleeding from any site
        RadioButtonGroup<String> unexplainedBleeding = new RadioButtonGroup<>();
        unexplainedBleeding.setLabel("Unexplained bleeding from any site");
        unexplainedBleeding.setItems(yesNoUnknown);
        unexplainedBleeding.setRequired(true);

        // Other symptom(s) (specify)
        TextField otherSymptoms = new TextField("Other symptom(s) (specify)");
        otherSymptoms.setPlaceholder("Enter other symptoms");

        // Date of symptom onset
        DatePicker dateOfSymptomOnset = new DatePicker("Date of symptom onset");
        dateOfSymptomOnset.setMax(LocalDate.now());
        dateOfSymptomOnset.setRequired(true);

        // Responsive steps
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("800px", 2),
            new FormLayout.ResponsiveStep("1200px", 3)
        );

        // Add all fields to the form
        form.add(
            fever,
            generalWeakness,
            malaise,
            soreThroat,
            chestPain,
            vomittingNausea,
            cough,
            oralUlcer,
            musclePain,
            abdominalCramps,
            headache,
            unexplainedBleeding,
            otherSymptoms,
            dateOfSymptomOnset
        );

        return form;
    }
}
