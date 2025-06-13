package com.jacreator.disease_form.views.mpox;

import java.time.LocalDate;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class MpoxEpidemiologicalView extends VerticalLayout{
// State for conditional fields
    private String patientHaveCutaneousEruptionValue = null;
    private String patientTouchAnimalsValue = null;

    // Form fields that need to be shown/hidden
    private DatePicker dateOnsetOfRash;
    private TextField kindOfAnimal;
    private DatePicker dateOfAnimalContact;
    private CheckboxGroup<String> typeOfContact;

    public MpoxEpidemiologicalView() {
        setWidthFull();
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Helper for Yes/No/Unknown
        String[] yesNoUnknown = {"Yes", "No", "Unknown"};

        // Travelled within the last 3 weeks before becoming ill?
        RadioButtonGroup<String> travelledWithinLastThreeweeks = new RadioButtonGroup<>();
        travelledWithinLastThreeweeks.setLabel("Travelled within the last 3 weeks before becoming ill?");
        travelledWithinLastThreeweeks.setItems(yesNoUnknown);
        travelledWithinLastThreeweeks.setRequired(true);

        // Does the patient have a cutaneous eruption?
        RadioButtonGroup<String> patientHaveCutaneousEruption = new RadioButtonGroup<>();
        patientHaveCutaneousEruption.setLabel("Does the patient have a cutaneous eruption?");
        patientHaveCutaneousEruption.setItems(yesNoUnknown);
        patientHaveCutaneousEruption.setRequired(true);

        // Date of onset of rash (conditional)
        dateOnsetOfRash = new DatePicker("Date of onset of rash");
        dateOnsetOfRash.setMax(LocalDate.now());
        dateOnsetOfRash.setRequired(true);
        dateOnsetOfRash.setVisible(false);

        // During onset of symptoms, did the patient have contact with one or more persons who had with similar symptoms?
        RadioButtonGroup<String> patientContactWithPersonSimilarSymptoms = new RadioButtonGroup<>();
        patientContactWithPersonSimilarSymptoms.setLabel("During onset of symptoms, did the patient have contact with one or more persons who had with similar symptoms?");
        patientContactWithPersonSimilarSymptoms.setItems(yesNoUnknown);
        patientContactWithPersonSimilarSymptoms.setRequired(true);

        // Did the patient touch a domestic or wild animal during the three weeks preceding symptom onset?
        RadioButtonGroup<String> patientTouchAnimals = new RadioButtonGroup<>();
        patientTouchAnimals.setLabel("Did the patient touch a domestic or wild animal during the three weeks preceding symptom onset?");
        patientTouchAnimals.setItems(yesNoUnknown);
        patientTouchAnimals.setRequired(true);

        // Name of village patient fell ill
        TextField nameOfVillagePatientFellIll = new TextField("Name of village patient fell ill");
        nameOfVillagePatientFellIll.setPlaceholder("Name of the village the patient fell ill");

        // What kind of animal? (conditional)
        kindOfAnimal = new TextField("What kind of animal?");
        kindOfAnimal.setPlaceholder("Enter type of animal touched");
        kindOfAnimal.setVisible(false);

        // Date of animal contact (conditional)
        dateOfAnimalContact = new DatePicker("Date of animal contact");
        dateOfAnimalContact.setMax(LocalDate.now());
        dateOfAnimalContact.setRequired(true);
        dateOfAnimalContact.setVisible(false);

        // Type of contact? (conditional)
        typeOfContact = new CheckboxGroup<>();
        typeOfContact.setLabel("Type of contact?");
        typeOfContact.setItems(
            "Rodents alive in the House",
            "Dead animal found in the forest",
            "Alive animal living in the forest",
            "Animal bought for meat"
        );
        typeOfContact.setVisible(false);

        // Is a smallpox vaccination scar present?
        RadioButtonGroup<String> smallpoxVaccineScarPresent = new RadioButtonGroup<>();
        smallpoxVaccineScarPresent.setLabel("Is a smallpox vaccination scar present?");
        smallpoxVaccineScarPresent.setItems(yesNoUnknown);
        smallpoxVaccineScarPresent.setRequired(true);

        // Responsive steps
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("800px", 2)
        );

        // Add all fields to the form
        form.add(
            travelledWithinLastThreeweeks,
            patientHaveCutaneousEruption,
            dateOnsetOfRash,
            patientContactWithPersonSimilarSymptoms,
            patientTouchAnimals,
            nameOfVillagePatientFellIll,
            kindOfAnimal,
            dateOfAnimalContact,
            typeOfContact,
            smallpoxVaccineScarPresent
        );

        // Conditional logic for patientHaveCutaneousEruption
        patientHaveCutaneousEruption.addValueChangeListener(event -> {
            boolean show = "Yes".equals(event.getValue());
            dateOnsetOfRash.setVisible(show);
        });

        // Conditional logic for patientTouchAnimals
        patientTouchAnimals.addValueChangeListener(event -> {
            boolean show = "Yes".equals(event.getValue());
            kindOfAnimal.setVisible(show);
            dateOfAnimalContact.setVisible(show);
            typeOfContact.setVisible(show);
        });

        return form;
    }
}
