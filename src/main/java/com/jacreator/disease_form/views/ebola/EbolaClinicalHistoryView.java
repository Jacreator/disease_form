package com.jacreator.disease_form.views.ebola;

import java.time.LocalDate;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class EbolaClinicalHistoryView extends VerticalLayout {
// Form fields
    private DatePicker dateOfOnset;
    private TextField placeOnset;
    private RadioButtonGroup<String> feverHistory;
    private DatePicker feverOnsetDate;
    private RadioButtonGroup<String> headache;
    private RadioButtonGroup<String> anorexia;
    private RadioButtonGroup<String> intenseFatigue;
    private RadioButtonGroup<String> diarrhoea;
    private RadioButtonGroup<String> abdominalPain;
    private RadioButtonGroup<String> muscleJointPain;
    private RadioButtonGroup<String> difficultySwallowing;
    private RadioButtonGroup<String> difficultyBreathing;
    private RadioButtonGroup<String> skinRash;
    private RadioButtonGroup<String> bleedingInjectionSite;
    private RadioButtonGroup<String> bleedingGums;
    private RadioButtonGroup<String> bleedingEyes;
    private RadioButtonGroup<String> blackBloodyStool;
    private RadioButtonGroup<String> bloodVomits;
    private RadioButtonGroup<String> bloodNose;
    private RadioButtonGroup<String> bloodVagina;
    private RadioButtonGroup<String> hiccups;
    private TextField others;

    public EbolaClinicalHistoryView() {
        setWidthFull();
        setPadding(true);
        setSpacing(true);
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();
        form.setWidthFull();

        // Set responsive steps for 3-column layout on larger screens
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("600px", 2),
            new FormLayout.ResponsiveStep("900px", 3)
        );

        // Date of Symptom Onset
        dateOfOnset = new DatePicker("Date of Symptom Onset");
        dateOfOnset.setMax(LocalDate.now());
        dateOfOnset.setRequired(true);
        dateOfOnset.setRequiredIndicatorVisible(true);
        dateOfOnset.setPlaceholder("DD-MM-YYYY");

        // Place of Symptom Onset
        placeOnset = new TextField("Place of Symptom Onset");
        placeOnset.setPlaceholder("Enter place Address");
        placeOnset.setRequired(true);
        placeOnset.setRequiredIndicatorVisible(true);

        // Fever (≥37.5 °C)
        feverHistory = new RadioButtonGroup<>("Fever (≥37.5 °C)");
        feverHistory.setItems("Yes", "No", "Unknown");
        feverHistory.setRequired(true);
        feverHistory.setRequiredIndicatorVisible(true);

        // Fever Onset Date
        feverOnsetDate = new DatePicker("Fever Onset Date");
        feverOnsetDate.setMax(LocalDate.now());
        feverOnsetDate.setRequired(true);
        feverOnsetDate.setRequiredIndicatorVisible(true);
        feverOnsetDate.setPlaceholder("YYYY-MM-DD");

        // Headache
        headache = new RadioButtonGroup<>("Headache");
        headache.setItems("Yes", "No", "Unknown");
        headache.setRequired(true);
        headache.setRequiredIndicatorVisible(true);

        // Empty column for layout alignment
        // (This is handled by the responsive layout automatically)

        // Anorexia/Loss of Appetite
        anorexia = new RadioButtonGroup<>("Anorexia/Loss of Appetite");
        anorexia.setItems("Yes", "No", "Unknown");
        anorexia.setRequired(true);
        anorexia.setRequiredIndicatorVisible(true);

        // Intense Fatigue
        intenseFatigue = new RadioButtonGroup<>("Intense Fatigue");
        intenseFatigue.setItems("Yes", "No", "Unknown");
        intenseFatigue.setRequired(true);
        intenseFatigue.setRequiredIndicatorVisible(true);

        // Diarrhoea
        diarrhoea = new RadioButtonGroup<>("Diarrhoea");
        diarrhoea.setItems("Yes", "No", "Unknown");
        diarrhoea.setRequired(true);
        diarrhoea.setRequiredIndicatorVisible(true);

        // Abdominal Pain
        abdominalPain = new RadioButtonGroup<>("Abdominal Pain");
        abdominalPain.setItems("Yes", "No", "Unknown");
        abdominalPain.setRequired(true);
        abdominalPain.setRequiredIndicatorVisible(true);

        // Muscle or Joint Pain
        muscleJointPain = new RadioButtonGroup<>("Muscle or Joint Pain");
        muscleJointPain.setItems("Yes", "No", "Unknown");
        muscleJointPain.setRequired(true);
        muscleJointPain.setRequiredIndicatorVisible(true);

        // Difficulty swallowing
        difficultySwallowing = new RadioButtonGroup<>("Difficulty swallowing");
        difficultySwallowing.setItems("Yes", "No", "Unknown");
        difficultySwallowing.setRequired(true);
        difficultySwallowing.setRequiredIndicatorVisible(true);

        // Difficulty breathing
        difficultyBreathing = new RadioButtonGroup<>("Difficulty breathing");
        difficultyBreathing.setItems("Yes", "No", "Unknown");
        difficultyBreathing.setRequired(true);
        difficultyBreathing.setRequiredIndicatorVisible(true);

        // Skin Rash
        skinRash = new RadioButtonGroup<>("Skin Rash");
        skinRash.setItems("Yes", "No", "Unknown");
        skinRash.setRequired(true);
        skinRash.setRequiredIndicatorVisible(true);

        // Bleeding from injection sites
        bleedingInjectionSite = new RadioButtonGroup<>("Bleeding from injection sites");
        bleedingInjectionSite.setItems("Yes", "No", "Unknown");
        bleedingInjectionSite.setRequired(true);
        bleedingInjectionSite.setRequiredIndicatorVisible(true);

        // Bleeding gums
        bleedingGums = new RadioButtonGroup<>("Bleeding gums");
        bleedingGums.setItems("Yes", "No", "Unknown");
        bleedingGums.setRequired(true);
        bleedingGums.setRequiredIndicatorVisible(true);

        // Bleeding into the eyes (Red Eyes)
        bleedingEyes = new RadioButtonGroup<>("Bleeding into the eyes (Red Eyes)");
        bleedingEyes.setItems("Yes", "No", "Unknown");
        bleedingEyes.setRequired(true);
        bleedingEyes.setRequiredIndicatorVisible(true);

        // Black or bloody stool
        blackBloodyStool = new RadioButtonGroup<>("Black or bloody stool");
        blackBloodyStool.setItems("Yes", "No", "Unknown");
        blackBloodyStool.setRequired(true);
        blackBloodyStool.setRequiredIndicatorVisible(true);

        // Blood in vomits
        bloodVomits = new RadioButtonGroup<>("Blood in vomits");
        bloodVomits.setItems("Yes", "No", "Unknown");
        bloodVomits.setRequired(true);
        bloodVomits.setRequiredIndicatorVisible(true);

        // Bleeding from the nose
        bloodNose = new RadioButtonGroup<>("Bleeding from the nose");
        bloodNose.setItems("Yes", "No", "Unknown");
        bloodNose.setRequired(true);
        bloodNose.setRequiredIndicatorVisible(true);

        // Bleeding from the vagina
        bloodVagina = new RadioButtonGroup<>("Bleeding from the vagina");
        bloodVagina.setItems("Yes", "No", "Unknown");
        bloodVagina.setRequired(true);
        bloodVagina.setRequiredIndicatorVisible(true);

        // Hiccups
        hiccups = new RadioButtonGroup<>("Hiccups");
        hiccups.setItems("Yes", "No", "Unknown");
        hiccups.setRequired(true);
        hiccups.setRequiredIndicatorVisible(true);

        // Others (Specify)
        others = new TextField("Others (Specify)");
        others.setPlaceholder("Enter other symptoms");
        others.setRequired(true);
        others.setRequiredIndicatorVisible(true);

        // Add all components to the form
        form.add(
            dateOfOnset,
            placeOnset,
            feverHistory,
            feverOnsetDate,
            headache,
            // Empty space for alignment (handled automatically by responsive layout)
            anorexia,
            intenseFatigue,
            diarrhoea,
            abdominalPain,
            muscleJointPain,
            difficultySwallowing,
            difficultyBreathing,
            skinRash,
            bleedingInjectionSite,
            bleedingGums,
            bleedingEyes,
            blackBloodyStool,
            bloodVomits,
            bloodNose,
            bloodVagina,
            hiccups,
            others
        );

        return form;
    }
  }
