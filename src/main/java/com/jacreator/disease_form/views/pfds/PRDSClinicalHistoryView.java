package com.jacreator.disease_form.views.pfds;

import java.time.LocalDate;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class PRDSClinicalHistoryView extends VerticalLayout {
  public PRDSClinicalHistoryView() {
    setWidthFull();

    add(buildForm());
  }

  // Helper for all symptom radio groups
  RadioButtonGroup<String> createSymptomGroup(String label) {
    RadioButtonGroup<String> group = new RadioButtonGroup<>();
    group.setLabel(label);
    group.setItems("Yes", "No", "Unknown");
    group.setRequired(true);
    return group;
  }

  private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // All symptom fields
        RadioButtonGroup<String> fever = createSymptomGroup("Fever (≥38 °C) or history of fever");
        RadioButtonGroup<String> soreThroat = createSymptomGroup("Sore throat");
        RadioButtonGroup<String> shortBreath = createSymptomGroup("Shortness of breath");
        RadioButtonGroup<String> headache = createSymptomGroup("Headache");
        RadioButtonGroup<String> vomit = createSymptomGroup("Vomiting");
        RadioButtonGroup<String> tired = createSymptomGroup("Tiredness");
        RadioButtonGroup<String> dehydrated = createSymptomGroup("Dehydration");
        RadioButtonGroup<String> nausea = createSymptomGroup("Nausea");
        RadioButtonGroup<String> chestPains = createSymptomGroup("Chest pains");
        RadioButtonGroup<String> diarrhea = createSymptomGroup("Diarrhea");
        RadioButtonGroup<String> lossSmell = createSymptomGroup("Loss of sense of smell");
        RadioButtonGroup<String> lossTaste = createSymptomGroup("Loss of sense of taste");
        RadioButtonGroup<String> redEyes = createSymptomGroup("Red Eyes");

        // Other symptom (text)
        TextField otherSymptoms = new TextField("Other symptom (please specify)");
        otherSymptoms.setPlaceholder("Other Symptoms");

        // Date of symptom onset
        DatePicker dateOfSymptomOnset = new DatePicker("Date of symptom onset");
        dateOfSymptomOnset.setMax(LocalDate.now());
        dateOfSymptomOnset.setRequired(true);

        // Add all fields to the form (3 columns per row)
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("600px", 2),
            new FormLayout.ResponsiveStep("900px", 3)
        );
        form.add(fever, soreThroat, shortBreath,
                headache, vomit, tired,
                dehydrated, nausea, chestPains,
                diarrhea, lossSmell, lossTaste,
                redEyes, otherSymptoms, dateOfSymptomOnset);

        return form;
    }
}
