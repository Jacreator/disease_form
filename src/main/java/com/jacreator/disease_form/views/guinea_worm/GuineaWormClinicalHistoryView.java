package com.jacreator.disease_form.views.guinea_worm;

import java.time.LocalDate;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class GuineaWormClinicalHistoryView extends VerticalLayout {
private RadioButtonGroup<String> firstSignSymptomGroup;
    private TextField specifyField;

    public GuineaWormClinicalHistoryView() {
        setWidthFull();
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // First sign/symptom before the emergence of worm
        firstSignSymptomGroup = new RadioButtonGroup<>();
        firstSignSymptomGroup.setLabel("First sign/symptom before the emergence of worm");
        firstSignSymptomGroup.setItems("Blister", "Itching", "Swelling", "Others");
        firstSignSymptomGroup.setRequired(true);

        // Specify (conditional)
        specifyField = new TextField("Specify");
        specifyField.setPlaceholder("Specify");
        specifyField.setVisible(false);

        firstSignSymptomGroup.addValueChangeListener(event -> {
            boolean show = "Others".equals(event.getValue());
            specifyField.setVisible(show);
            if (!show) {
                specifyField.clear();
            }
        });

        // Emergence of Guinea Worm
        RadioButtonGroup<String> firstOfGuineaWorm = new RadioButtonGroup<>();
        firstOfGuineaWorm.setLabel("Emergence of Guinea Worm");
        firstOfGuineaWorm.setItems("Yes", "No", "Unknown");
        firstOfGuineaWorm.setRequired(true);

        // Number of Worms
        TextField numberOfWorms = new TextField("Number of Worms");
        numberOfWorms.setPlaceholder("Number of Worms");

        // Is this the first Guinea Worm emerged this year?
        RadioButtonGroup<String> isThisTheFirstGuineaWorm = new RadioButtonGroup<>();
        isThisTheFirstGuineaWorm.setLabel("Is this the first Guinea Worm emerged this year?");
        isThisTheFirstGuineaWorm.setItems("Yes", "No", "Unknown");
        isThisTheFirstGuineaWorm.setRequired(true);

        // Date the First guinea worm emerged
        DatePicker dateTheFirstGuineaWormEmerged = new DatePicker("Date the First guinea worm emerged");
        dateTheFirstGuineaWormEmerged.setMax(LocalDate.now());

        // Was the case detected before Worm emerged?
        RadioButtonGroup<String> wasTheCaseDetectedBefore = new RadioButtonGroup<>();
        wasTheCaseDetectedBefore.setLabel("Was the case detected before Worm emerged?");
        wasTheCaseDetectedBefore.setItems("Yes", "No", "Unknown");
        wasTheCaseDetectedBefore.setRequired(true);

        // Received any Health Education?
        RadioButtonGroup<String> healthEducation = new RadioButtonGroup<>();
        healthEducation.setLabel("Received any Health Education?");
        healthEducation.setItems("Yes", "No", "Unknown");
        healthEducation.setRequired(true);

        // Patient entered any Water Source?
        RadioButtonGroup<String> waterSource = new RadioButtonGroup<>();
        waterSource.setLabel("Patient entered any Water Source?");
        waterSource.setItems("Yes", "No", "Unknown");
        waterSource.setRequired(true);

        // Place Managed
        RadioButtonGroup<String> placeManaged = new RadioButtonGroup<>();
        placeManaged.setLabel("Place Managed");
        placeManaged.setItems("CCC", "Home", "Health Center", "Hospitals");
        placeManaged.setRequired(true);

        // Name of Health Facility/Health Center/Other Centers if patient was hospitalized
        TextField nameOfHealthFacility = new TextField("Name of Health Facility/Health Center/Other Centers if patient was hospitalized");
        nameOfHealthFacility.setPlaceholder("Name of Health Facility/Health Center/Other");

        // Admission Date
        DatePicker admissionDate = new DatePicker("Admission Date");
        admissionDate.setMax(LocalDate.now());

        // Discharged Date
        DatePicker dischargedDate = new DatePicker("Discharged Date");
        dischargedDate.setMax(LocalDate.now());

        // Location of Worm?
        TextField wormLocation = new TextField("Location of Worm?");
        wormLocation.setPlaceholder("Location of Worm?");

        // Date Worm detected
        DatePicker dateWormDetected = new DatePicker("Date Worm detected");
        dateWormDetected.setMax(LocalDate.now());

        // Date Worm completely expelled
        DatePicker dateWormExpelled = new DatePicker("Date Worm completely expelled");
        dateWormExpelled.setMax(LocalDate.now());

        // Responsive steps
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("800px", 2),
            new FormLayout.ResponsiveStep("1200px", 3)
        );

        // Add all fields to the form
        form.add(
            firstSignSymptomGroup,
            specifyField,
            firstOfGuineaWorm,
            numberOfWorms,
            isThisTheFirstGuineaWorm,
            dateTheFirstGuineaWormEmerged,
            wasTheCaseDetectedBefore,
            healthEducation,
            waterSource,
            placeManaged,
            nameOfHealthFacility,
            admissionDate,
            dischargedDate,
            wormLocation,
            dateWormDetected,
            dateWormExpelled
        );

        return form;
    }
}
