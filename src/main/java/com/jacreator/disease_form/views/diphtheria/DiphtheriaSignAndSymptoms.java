package com.jacreator.disease_form.views.diphtheria;

import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class DiphtheriaSignAndSymptoms extends VerticalLayout {
  private RadioButtonGroup<String> fever;
  private RadioButtonGroup<String> cough;
  private RadioButtonGroup<String> pharyngitis;
  private RadioButtonGroup<String> tonsilitis;
  private RadioButtonGroup<String> laryngitis;
  private RadioButtonGroup<String> nasopharyngitis;
  private RadioButtonGroup<String> pseudoMembrane;
  private RadioButtonGroup<String> neckSwelling;
  private RadioButtonGroup<String> skinPresentation;
  private CheckboxGroup<String> site;
  private TextField otherSignsAndSymptoms;

  public DiphtheriaSignAndSymptoms() {
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
        new FormLayout.ResponsiveStep("900px", 3));

    fever = new RadioButtonGroup<>("Fever");
    fever.setItems("yes", "no");
    fever.setRequired(true);
    fever.setRequiredIndicatorVisible(true);

    cough = new RadioButtonGroup<>("Cough");
    cough.setItems("yes", "no");
    cough.setRequired(true);
    cough.setRequiredIndicatorVisible(true);

    pharyngitis = new RadioButtonGroup<>("Pharyngitis");
    pharyngitis.setItems("yes", "no");
    pharyngitis.setRequired(true);
    pharyngitis.setRequiredIndicatorVisible(true);

    tonsilitis = new RadioButtonGroup<>("Tonsilitis");
    tonsilitis.setItems("yes", "no");
    tonsilitis.setRequired(true);
    tonsilitis.setRequiredIndicatorVisible(true);

    laryngitis = new RadioButtonGroup<>("Laryngitis");
    laryngitis.setItems("yes", "no");
    laryngitis.setRequired(true);
    laryngitis.setRequiredIndicatorVisible(true);

    nasopharyngitis = new RadioButtonGroup<>("Nasopharyngitis");
    nasopharyngitis.setItems("yes", "no");
    nasopharyngitis.setRequired(true);
    nasopharyngitis.setRequiredIndicatorVisible(true);

    pseudoMembrane = new RadioButtonGroup<>("Pseudo-membrane");
    pseudoMembrane.setItems("yes", "no");
    pseudoMembrane.setRequired(true);
    pseudoMembrane.setRequiredIndicatorVisible(true);

    neckSwelling = new RadioButtonGroup<>("Neck swelling");
    neckSwelling.setItems("yes", "no");
    neckSwelling.setRequired(true);
    neckSwelling.setRequiredIndicatorVisible(true);

    skinPresentation = new RadioButtonGroup<>("Skin presentation");
    skinPresentation.setItems("yes", "no");
    skinPresentation.setRequired(true);
    skinPresentation.setRequiredIndicatorVisible(true);

    site = new CheckboxGroup<>("Site");
    site.setItems("Upper limb", "Lower limb", "Trunk", "Head", "Neck", "Genital", "Others");
    site.setRequired(true);
    site.setRequiredIndicatorVisible(true);

    otherSignsAndSymptoms = new TextField("Other signs and symptoms");
    otherSignsAndSymptoms.setVisible(false);
    otherSignsAndSymptoms.setRequired(false);

    site.addValueChangeListener(e -> {
      boolean showOther = e.getValue().contains("Others");
      otherSignsAndSymptoms.setVisible(showOther);
      otherSignsAndSymptoms.setRequired(showOther);
      otherSignsAndSymptoms.setRequiredIndicatorVisible(showOther);
      if (!showOther) {
        otherSignsAndSymptoms.clear();
      }
    });

    form.add(
        fever,
        cough,
        pharyngitis,
        tonsilitis,
        laryngitis,
        nasopharyngitis,
        pseudoMembrane,
        neckSwelling,
        skinPresentation,
        site,
        otherSignsAndSymptoms);

    return form;
  }
}
