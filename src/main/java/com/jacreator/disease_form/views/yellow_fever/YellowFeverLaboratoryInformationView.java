package com.jacreator.disease_form.views.yellow_fever;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class YellowFeverLaboratoryInformationView extends VerticalLayout {
private static final List<String> TESTING_LABORATORY_DATA = Arrays.asList(
            "ACEGID -African Centre of Excellence for Genomics of Infectious Diseases, Ogun",
            "AE-FUTHA -Alex Ekwueme Federal University Teaching Hospital Virology Laboratory",
            "BUK -Bayero University Kano Centre for Infectious Disease and Research, Kano",
            "FMC JALINGO -Federal Medical Centre, Jalingo, Taraba",
            "FMC OWO -Federal Medical Centre Owo, Ondo",
            "ISTH -Irrua Specialist Teaching Hospital, Edo",
            "LUTH -Lagos University Teaching Hospital Virology Laboratory, Lagos",
            "MOGID -Molecular Genetics and Infectious Diseases Research Laboratory, Bauchi",
            "NRL -National Reference Laboratory Gaduwa, FCT"
    );

    public YellowFeverLaboratoryInformationView() {
        setWidthFull();
        
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Specimen collected
        RadioButtonGroup<String> specimenCollected = new RadioButtonGroup<>();
        specimenCollected.setLabel("Specimen collected");
        specimenCollected.setItems("Yes", "No", "Unknown");
        specimenCollected.setRequired(true);

        // Date specimen collected
        DatePicker dateSpecimenCollected = new DatePicker("Date specimen collected");
        dateSpecimenCollected.setMax(LocalDate.now());
        dateSpecimenCollected.setRequired(true);
        dateSpecimenCollected.setVisible(false);

        // Type of specimen collected
        CheckboxGroup<String> specimenType = new CheckboxGroup<>();
        specimenType.setLabel("Type of specimen collected?");
        specimenType.setItems("Blood", "Sera");
        specimenType.setVisible(false);

        // Date specimen sent
        DatePicker dateSpecimenSent = new DatePicker("Date specimen sent");
        dateSpecimenSent.setMax(LocalDate.now());
        dateSpecimenSent.setRequired(true);
        dateSpecimenSent.setVisible(false);

        // Name of testing laboratory
        ComboBox<String> nameOfTestingLaboratory = new ComboBox<>("Name of testing laboratory");
        nameOfTestingLaboratory.setItems(TESTING_LABORATORY_DATA);
        nameOfTestingLaboratory.setRequired(true);
        nameOfTestingLaboratory.setVisible(false);

        // Divider
        Label labResultDivider = new Label("Laboratory result");
        labResultDivider.getStyle().set("font-weight", "bold").set("margin", "16px 0 8px 0");
        labResultDivider.setVisible(false);

        // Blood specimen fields
        Div bloodFields = buildBloodFields();
        bloodFields.setVisible(false);

        // Sera specimen fields
        Div seraFields = buildSeraFields();
        seraFields.setVisible(false);

        // Show/hide specimen fields based on "Specimen collected"
        specimenCollected.addValueChangeListener(e -> {
            boolean yes = "Yes".equalsIgnoreCase(e.getValue());
            dateSpecimenCollected.setVisible(yes);
            specimenType.setVisible(yes);
            nameOfTestingLaboratory.setVisible(yes);
            labResultDivider.setVisible(yes);
            if (!yes) {
                dateSpecimenSent.setVisible(false);
                bloodFields.setVisible(false);
                seraFields.setVisible(false);
            }
        });

        // Show/hide dateSpecimenSent, bloodFields, seraFields based on specimenType
        specimenType.addValueChangeListener(e -> {
            Set<String> selected = e.getValue();
            dateSpecimenSent.setVisible(!selected.isEmpty());
            bloodFields.setVisible(selected.contains("Blood"));
            seraFields.setVisible(selected.contains("Sera"));
        });

        // Add all fields to the form
        form.add(specimenCollected, dateSpecimenCollected, specimenType);
        form.add(dateSpecimenSent, nameOfTestingLaboratory);
        form.add(labResultDivider, 2);
        form.add(bloodFields, 2);
        form.add(seraFields, 2);

        return form;
    }

    private Div buildBloodFields() {
        Div container = new Div();

        // Blood specimen received
        RadioButtonGroup<String> bloodSpecimenReceived = new RadioButtonGroup<>();
        bloodSpecimenReceived.setLabel("Blood specimen received");
        bloodSpecimenReceived.setItems("Yes", "No");
        bloodSpecimenReceived.setRequired(true);

        // Date blood specimen received
        DatePicker dateBloodSpecimenReceived = new DatePicker("Date blood specimen received");
        dateBloodSpecimenReceived.setMax(LocalDate.now());
        dateBloodSpecimenReceived.setRequired(true);
        dateBloodSpecimenReceived.setVisible(false);

        // Specimen condition
        RadioButtonGroup<String> specimenConditionBlood = new RadioButtonGroup<>();
        specimenConditionBlood.setLabel("Specimen condition");
        specimenConditionBlood.setItems("Adequate", "Not adequate");
        specimenConditionBlood.setRequired(true);
        specimenConditionBlood.setVisible(false);

        // Test conducted
        CheckboxGroup<String> testConductedBlood = new CheckboxGroup<>();
        testConductedBlood.setLabel("Test conducted");
        testConductedBlood.setItems("Igm", "IgG(acute)", "IgG(convalescent)", "Microscopy", "PRNT", "PCR/RT-PCR");
        testConductedBlood.setVisible(false);

        // Igm result
        Div igmFields = buildResultFields("Igm result for blood specimen", "igmResultBlood", "dateResultReleasedBloodIgm");
        igmFields.setVisible(false);

        // IgG(acute) result
        Div iggAcuteFields = buildResultFields("IgG(Acute) result for blood specimen", "iggAcuteResultBlood", "dateResultReleasedBloodIggA");
        iggAcuteFields.setVisible(false);

        // IgG(convalescent) result
        Div iggConvalescentFields = buildResultFields("IgG(Convalescent) result for blood specimen", "iggConvalescentResultBlood", "dateResultReleasedBloodIggc");
        iggConvalescentFields.setVisible(false);

        // Microscopy result
        Div microscopyFields = buildResultFields("Microscopy result for blood", "microscopyResultBlood", "dateResultReleasedBloodMicroscopy");
        microscopyFields.setVisible(false);

        // PCR/RT-PCR result
        Div pcrFields = buildResultFields("PCR/RT-PCR result for blood", "pcrRtPcrResultBlood", "dateResultReleasedBloodPcr");
        pcrFields.setVisible(false);

        // PRNT result
        Div prntFields = buildResultFields("PRNT result for blood specimen", "prntResultBlood", "dateResultReleasedBloodPrnt");
        prntFields.setVisible(false);

        // Show/hide subfields based on "Blood specimen received"
        bloodSpecimenReceived.addValueChangeListener(e -> {
            boolean yes = "Yes".equalsIgnoreCase(e.getValue());
            dateBloodSpecimenReceived.setVisible(yes);
            specimenConditionBlood.setVisible(yes);
            testConductedBlood.setVisible(yes);
            if (!yes) {
                igmFields.setVisible(false);
                iggAcuteFields.setVisible(false);
                iggConvalescentFields.setVisible(false);
                microscopyFields.setVisible(false);
                pcrFields.setVisible(false);
                prntFields.setVisible(false);
            }
        });

        // Show/hide result fields based on testConductedBlood
        testConductedBlood.addValueChangeListener(e -> {
            Set<String> selected = e.getValue();
            igmFields.setVisible(selected.contains("Igm"));
            iggAcuteFields.setVisible(selected.contains("IgG(acute)"));
            iggConvalescentFields.setVisible(selected.contains("IgG(convalescent)"));
            microscopyFields.setVisible(selected.contains("Microscopy"));
            pcrFields.setVisible(selected.contains("PCR/RT-PCR"));
            prntFields.setVisible(selected.contains("PRNT"));
        });

        container.add(bloodSpecimenReceived, dateBloodSpecimenReceived, specimenConditionBlood, testConductedBlood,
                igmFields, iggAcuteFields, iggConvalescentFields, microscopyFields, pcrFields, prntFields, new Hr());
        return container;
    }

    private Div buildSeraFields() {
        Div container = new Div();

        // Sera specimen received
        RadioButtonGroup<String> seraSpecimenReceived = new RadioButtonGroup<>();
        seraSpecimenReceived.setLabel("Sera specimen received");
        seraSpecimenReceived.setItems("Yes", "No");
        seraSpecimenReceived.setRequired(true);

        // Date sera specimen received
        DatePicker dateSeraSpecimenReceived = new DatePicker("Date specimen received");
        dateSeraSpecimenReceived.setMax(LocalDate.now());
        dateSeraSpecimenReceived.setRequired(true);
        dateSeraSpecimenReceived.setVisible(false);

        // Specimen condition
        RadioButtonGroup<String> specimenConditionSera = new RadioButtonGroup<>();
        specimenConditionSera.setLabel("Specimen condition");
        specimenConditionSera.setItems("Adequate", "Not Adequate");
        specimenConditionSera.setRequired(true);
        specimenConditionSera.setVisible(false);

        // Test conducted
        CheckboxGroup<String> testConductedSera = new CheckboxGroup<>();
        testConductedSera.setLabel("Test conducted");
        testConductedSera.setItems("Igm", "IgG(acute)", "IgG(convalescent)", "Microscopy", "PRNT", "PCR/RT-PCR");
        testConductedSera.setVisible(false);

        // Igm result
        Div igmFields = buildResultFields("Igm result for sera specimen", "igmResultSera", "dateResultReleasedSeraIgm");
        igmFields.setVisible(false);

        // IgG(acute) result
        Div iggAcuteFields = buildResultFields("IgG(Acute) result for sera specimen", "iggAcuteResultSera", "dateResultReleasedSeraIgga");
        iggAcuteFields.setVisible(false);

        // IgG(convalescent) result
        Div iggConvalescentFields = buildResultFields("IgG(convalescent) result for sera specimen", "iggConvalescentResultSera", "dateResultReleasedSeraIggc");
        iggConvalescentFields.setVisible(false);

        // Microscopy result
        Div microscopyFields = buildResultFields("Microscopy result for sera", "microscopyResultSera", "dateResultReleasedSeraMicroscopy");
        microscopyFields.setVisible(false);

        // PCR/RT-PCR result
        Div pcrFields = buildResultFields("PCR/RT-PCR result for sera", "pcrRtPcrResultSera", "dateResultReleasedSeraPcr");
        pcrFields.setVisible(false);

        // PRNT result
        Div prntFields = buildResultFields("PRNT result for sera specimen", "prntResultSera", "dateResultReleasedSeraPrnt");
        prntFields.setVisible(false);

        // Show/hide subfields based on "Sera specimen received"
        seraSpecimenReceived.addValueChangeListener(e -> {
            boolean yes = "Yes".equalsIgnoreCase(e.getValue());
            dateSeraSpecimenReceived.setVisible(yes);
            specimenConditionSera.setVisible(yes);
            testConductedSera.setVisible(yes);
            if (!yes) {
                igmFields.setVisible(false);
                iggAcuteFields.setVisible(false);
                iggConvalescentFields.setVisible(false);
                microscopyFields.setVisible(false);
                pcrFields.setVisible(false);
                prntFields.setVisible(false);
            }
        });

        // Show/hide result fields based on testConductedSera
        testConductedSera.addValueChangeListener(e -> {
            Set<String> selected = e.getValue();
            igmFields.setVisible(selected.contains("Igm"));
            iggAcuteFields.setVisible(selected.contains("IgG(acute)"));
            iggConvalescentFields.setVisible(selected.contains("IgG(convalescent)"));
            microscopyFields.setVisible(selected.contains("Microscopy"));
            pcrFields.setVisible(selected.contains("PCR/RT-PCR"));
            prntFields.setVisible(selected.contains("PRNT"));
        });

        container.add(seraSpecimenReceived, dateSeraSpecimenReceived, specimenConditionSera, testConductedSera,
                igmFields, iggAcuteFields, iggConvalescentFields, microscopyFields, pcrFields, prntFields, new Hr());
        return container;
    }

    private Div buildResultFields(String label, String resultName, String dateName) {
        Div container = new Div();

        // Result radio group
        RadioButtonGroup<String> result = new RadioButtonGroup<>();
        result.setLabel(label);
        result.setItems("Positive", "Negative", "Inconclusive", "Pending", "Not done");
        result.setRequired(true);

        // Date result released
        DatePicker dateResultReleased = new DatePicker("Date result released");
        dateResultReleased.setMax(LocalDate.now());
        dateResultReleased.setRequired(true);

        container.add(result, dateResultReleased);
        return container;
    }
}
