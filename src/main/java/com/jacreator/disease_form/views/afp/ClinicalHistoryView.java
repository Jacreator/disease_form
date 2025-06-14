package com.jacreator.disease_form.views.afp;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class ClinicalHistoryView extends VerticalLayout {
  public ClinicalHistoryView() {
    FormLayout form = new FormLayout();

    String[] yesNoUnknown = { "Yes", "No", "Unknown" };
    String[] yesNo = { "Yes", "No" };
    String[] paralysisSite = { "Left Arm", "Right Arm", "Left Leg", "Right Leg" };

    RadioButtonGroup<String> feverOnset = new RadioButtonGroup<>();
    feverOnset.setLabel("Fever at the onset");
    feverOnset.setItems(yesNoUnknown);

    RadioButtonGroup<String> progressiveAnalysis = new RadioButtonGroup<>();
    progressiveAnalysis.setLabel("Progressive analysis");
    progressiveAnalysis.setItems(yesNoUnknown);

    RadioButtonGroup<String> paralysisAcute = new RadioButtonGroup<>();
    paralysisAcute.setLabel("Is Paralysis flaccid and acute?");
    paralysisAcute.setItems(yesNoUnknown);

    RadioButtonGroup<String> assymetric = new RadioButtonGroup<>();
    assymetric.setLabel("Assymetric");
    assymetric.setItems(yesNoUnknown);

    ComboBox<String> paralysisSiteCombo = new ComboBox<>("Site of paralysis");
    paralysisSiteCombo.setItems(paralysisSite);

    RadioButtonGroup<String> paralysedLimb = new RadioButtonGroup<>();
    paralysedLimb.setLabel("Paralyzed limb(s) sensitive to pain?");
    paralysedLimb.setItems(yesNo);

    RadioButtonGroup<String> injectionOnset = new RadioButtonGroup<>();
    injectionOnset.setLabel("Was there any injection before onset of paralysis?");
    injectionOnset.setItems(yesNo);

    ComboBox<String> injectionSiteCombo = new ComboBox<>("If Yes, indicate site of injection");
    injectionSiteCombo.setItems(paralysisSite);

    RadioButtonGroup<String> investigationAfp = new RadioButtonGroup<>();
    investigationAfp.setLabel("After investigation, was this a true AFP?");
    investigationAfp.setItems(yesNo);

    RadioButtonGroup<String> immunocompromised = new RadioButtonGroup<>();
    immunocompromised.setLabel("Immunocompromised status suspected?");
    immunocompromised.setItems(yesNoUnknown);

    RadioButtonGroup<String> hospitalised = new RadioButtonGroup<>();
    hospitalised.setLabel("Hospitalised?");
    hospitalised.setItems(yesNo);

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    form.add(
        feverOnset, progressiveAnalysis, paralysisAcute, assymetric,
        paralysisSiteCombo, paralysedLimb, injectionOnset, injectionSiteCombo,
        investigationAfp, immunocompromised, hospitalised);

    add(form);
  }
}
