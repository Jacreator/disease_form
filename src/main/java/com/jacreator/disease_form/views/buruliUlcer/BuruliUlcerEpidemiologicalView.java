package com.jacreator.disease_form.views.buruliUlcer;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.Route;

import java.util.LinkedHashMap;
import java.util.Map;

@Route("epidemiological")
public class BuruliUlcerEpidemiologicalView extends VerticalLayout {

  // Comorbidity options
  private static final Map<String, String> comorbidityOptions = new LinkedHashMap<>();
  static {
    comorbidityOptions.put("hypertension", "Hypertension");
    comorbidityOptions.put("diabetes", "Diabetes");
    comorbidityOptions.put("respiratory_diseases", "Respiratory diseases");
    comorbidityOptions.put("Immunocompromised conditions", "Immunocompromised conditions");
    comorbidityOptions.put("obesity", "Obesity");
    comorbidityOptions.put("Chronic kidney disease", "Chronic kidney disease");
    comorbidityOptions.put("Liver disease", "Liver diseases");
    comorbidityOptions.put("Neurological conditions", "Neurological conditions");
  }

  public BuruliUlcerEpidemiologicalView() {
    setWidthFull();
    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Source of Drinking Water
    RadioButtonGroup<String> sourceOfWater = new RadioButtonGroup<>();
    sourceOfWater.setLabel("Source of Drinking Water");
    sourceOfWater.setItems("Pipeborne", "Bole hole/well", "River/stream", "Pond/stagnant");
    sourceOfWater.setRequired(true);

    // Any Family History Of Buruli
    RadioButtonGroup<String> anyFamilyHistoryOfBuruli = new RadioButtonGroup<>();
    anyFamilyHistoryOfBuruli.setLabel("Any Family History Of Buruli");
    anyFamilyHistoryOfBuruli.setItems("Yes", "No", "Unknown");
    anyFamilyHistoryOfBuruli.setRequired(true);

    // History Of Trauma
    RadioButtonGroup<String> historyOfTrauma = new RadioButtonGroup<>();
    historyOfTrauma.setLabel("History Of Trauma");
    historyOfTrauma.setItems("Yes", "No", "Unknown");
    historyOfTrauma.setRequired(true);

    // Vaccination Status
    RadioButtonGroup<String> vaccinationStatus = new RadioButtonGroup<>();
    vaccinationStatus.setLabel("Vaccination Status");
    vaccinationStatus.setItems("Vaccinated", "Not vaccinated", "Unknown");
    vaccinationStatus.setRequired(true);

    // Comorbidity Section Label
    Label comorbidityLabel = new Label("Comorbidity");
    comorbidityLabel.getStyle().set("font-weight", "bold").set("margin", "16px 0 8px 0");
    form.add(comorbidityLabel, 2);

    // Comorbidity fields
    Map<String, RadioButtonGroup<String>> comorbidityGroups = new LinkedHashMap<>();
    for (Map.Entry<String, String> entry : comorbidityOptions.entrySet()) {
      RadioButtonGroup<String> group = new RadioButtonGroup<>();
      group.setLabel(entry.getValue());
      group.setItems("Yes", "No", "Unknown");
      comorbidityGroups.put(entry.getKey(), group);
      form.add(group);
    }

    // Closeness To Stagnant Water
    RadioButtonGroup<String> closenessStagnantWater = new RadioButtonGroup<>();
    closenessStagnantWater.setLabel("Closeness To Stagnant Water");
    closenessStagnantWater.setItems("Yes", "No");
    closenessStagnantWater.setRequired(true);

    // Add all fields to the form
    form.add(sourceOfWater, anyFamilyHistoryOfBuruli);
    form.add(historyOfTrauma, vaccinationStatus);
    // Comorbidity fields already added above
    form.add(closenessStagnantWater);

    return form;
  }
}
