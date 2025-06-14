package com.jacreator.disease_form.views.buruliUlcer;

import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("clinical-history")
public class BuruliUlcerClinicalHistoryView extends VerticalLayout {

  public BuruliUlcerClinicalHistoryView() {
    setWidthFull();

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Painless Swelling Of The Leg
    RadioButtonGroup<String> swellingLeg = new RadioButtonGroup<>();
    swellingLeg.setLabel("Painless Swelling Of The Leg");
    swellingLeg.setItems("Yes", "No", "Unknown");
    swellingLeg.setRequired(true);

    // Painless Swelling Of The Arm
    RadioButtonGroup<String> swellingArm = new RadioButtonGroup<>();
    swellingArm.setLabel("Painless Swelling Of The Arm");
    swellingArm.setItems("Yes", "No", "Unknown");
    swellingArm.setRequired(true);

    // Painless Swelling Of The Face
    RadioButtonGroup<String> swellingFace = new RadioButtonGroup<>();
    swellingFace.setLabel("Painless Swelling Of The Face");
    swellingFace.setItems("Yes", "No", "Unknown");
    swellingFace.setRequired(true);

    // Skin Ulcer
    RadioButtonGroup<String> skinUlcer = new RadioButtonGroup<>();
    skinUlcer.setLabel("Skin Ulcer");
    skinUlcer.setItems("Yes", "No", "Unknown");
    skinUlcer.setRequired(true);

    // Osteomyelitis
    RadioButtonGroup<String> osteomyelitis = new RadioButtonGroup<>();
    osteomyelitis.setLabel("Osteomyelitis");
    osteomyelitis.setItems("Yes", "No", "Unknown");
    osteomyelitis.setRequired(true);

    // Plaque
    RadioButtonGroup<String> plaque = new RadioButtonGroup<>();
    plaque.setLabel("Plaque");
    plaque.setItems("Yes", "No", "Unknown");
    plaque.setRequired(true);

    // The Appearance Of Lesions (CheckboxGroup)
    CheckboxGroup<String> appearanceOfLesion = new CheckboxGroup<>();
    appearanceOfLesion.setLabel("The Appearance Of Lesions");
    appearanceOfLesion.setItems("Upper limbs", "Lower limb", "Abdomen", "Immunocompromised conditions");

    // Disability Presence
    RadioButtonGroup<String> disabilityPresence = new RadioButtonGroup<>();
    disabilityPresence.setLabel("Disability Presence");
    disabilityPresence.setItems("Yes", "No");
    disabilityPresence.setRequired(true);

    // Other Symptom Please Specify
    TextField otherSymptoms = new TextField("Other Symptom Please Specify");
    otherSymptoms.setPlaceholder("othersymptoms");
    otherSymptoms.setRequired(true);

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    // Add all fields to the form
    form.add(swellingLeg, swellingArm, swellingFace);
    form.add(skinUlcer, osteomyelitis, plaque);
    form.add(appearanceOfLesion, disabilityPresence, otherSymptoms);

    // Submit button
    // Button submit = new Button("Submit", event -> {
    //   // You can collect all values here and process as needed
    //   Notification.show("Form submitted!");
    // });
    // form.add(submit, 3);

    return form;
  }
}
