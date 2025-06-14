package com.jacreator.disease_form.views.yew;

import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;

public class YewClinicalHistoryView extends VerticalLayout {
  private static final List<String> YAW = Arrays.asList(
      "Papilloma/Papules", "Ulcers", "Macules", "Swelling of bones and joints",
      "Hyperkeratosis of Palms/soles", "None of the above");
  private static final List<String> DRUGS = Arrays.asList(
      "Azithromycin(no of 500mg tablets)",
      "Benzathine Ibenzylpenicillin(0.6MU OR 1.2MU)",
      "Others");

  public YewClinicalHistoryView() {
    setWidthFull();

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Clinical forms of Yaws
    ComboBox<String> clinicalForms = new ComboBox<>("Clinical forms of Yaws");
    clinicalForms.setItems(YAW);
    clinicalForms.setPlaceholder("Select Option");
    clinicalForms.setRequired(true);

    // Photograph of Lesion (file upload)
    MemoryBuffer buffer = new MemoryBuffer();
    Upload photographUpload = new Upload(buffer);
    photographUpload.setAcceptedFileTypes("image/*");
    photographUpload.setMaxFiles(1);
    photographUpload.setDropLabel(new Label("Upload Photograph of Lesion"));
    photographUpload.setWidthFull();

    // Treatment Given
    RadioButtonGroup<String> treatmentGiven = new RadioButtonGroup<>();
    treatmentGiven.setLabel("Treatment Given");
    treatmentGiven.setItems("Yes", "No");

    // Drugs Given
    ComboBox<String> drugsGiven = new ComboBox<>("Drugs Given");
    drugsGiven.setItems(DRUGS);
    drugsGiven.setPlaceholder("Select Option");
    drugsGiven.setRequired(true);

    // Others (specify)
    TextField others = new TextField("Others (specify)");
    others.setPlaceholder("Other (specify)");

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    // Add all fields to the form
    form.add(clinicalForms, photographUpload, treatmentGiven, drugsGiven, others);

    return form;
  }
}
