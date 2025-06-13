package com.jacreator.disease_form.views.measles;

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
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class MeaslesLaboratoryInformationView extends VerticalLayout{
// State for conditional fields
    private String specimenCollectedValue = null;
    private List<String> sampleTypeValue = null;
    private String bloodSerumSampleReceivedValue = null;
    private String measlesSerologyResultBloodSerumValue = null;
    private String nasopharyngealSwabReceivedValue = null;

    // Form fields that need to be shown/hidden
    private DatePicker dateSpecimenCollected;
    private CheckboxGroup<String> sampleType;
    private DatePicker dateSpecimenSent;
    private ComboBox<String> nameOfTestingLaboratory;

    // Blood/Serum
    private RadioButtonGroup<String> bloodSerumSampleReceived;
    private DatePicker dateSpecimenReceivedBloodSerum;
    private TextField laboratoryIdBloodSerum;
    private RadioButtonGroup<String> sampleConditionBloodSerum;
    private RadioButtonGroup<String> measlesSerologyResultBloodSerum;
    private DatePicker dateResultReleasedMeasles;
    private RadioButtonGroup<String> rubellaSerologyResultBloodSerum;
    private DatePicker dateResultReleasedRubella;

    // Nasopharyngeal Swab
    private RadioButtonGroup<String> nasopharyngealSwabReceived;
    private DatePicker dateSpecimenReceivedNasopharyngealSwab;
    private TextField laboratoryIdNasopharyngealSwab;
    private RadioButtonGroup<String> sampleConditionNasopharyngealSwab;
    private RadioButtonGroup<String> pcrResult;
    private DatePicker dateResultReleasedPcr;

    public MeaslesLaboratoryInformationView() {
        setWidthFull();
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Laboratory options
        List<String> laboratoryOptions = Arrays.asList(
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

        // Specimen collected
        RadioButtonGroup<String> specimenCollected = new RadioButtonGroup<>();
        specimenCollected.setLabel("Specimen collected");
        specimenCollected.setItems("Yes", "No", "Unknown");
        specimenCollected.setRequired(true);

        // Date specimen collected
        dateSpecimenCollected = new DatePicker("Date specimen collected");
        dateSpecimenCollected.setMax(LocalDate.now());
        dateSpecimenCollected.setRequired(true);
        dateSpecimenCollected.setVisible(false);

        // Type of specimen collected
        sampleType = new CheckboxGroup<>();
        sampleType.setLabel("Type of specimen collected?");
        sampleType.setItems("Blood", "Serum", "Nasopharyngeal swab");
        sampleType.setRequired(true);
        sampleType.setVisible(false);

        // Date specimen sent
        dateSpecimenSent = new DatePicker("Date specimen sent");
        dateSpecimenSent.setMax(LocalDate.now());
        dateSpecimenSent.setRequired(true);
        dateSpecimenSent.setVisible(false);

        // Name of testing laboratory
        nameOfTestingLaboratory = new ComboBox<>("Name of testing laboratory");
        nameOfTestingLaboratory.setItems(laboratoryOptions);
        nameOfTestingLaboratory.setPlaceholder("Select Laboratory Name");
        nameOfTestingLaboratory.setRequired(true);
        nameOfTestingLaboratory.setVisible(false);

        // Blood/Serum section
        bloodSerumSampleReceived = new RadioButtonGroup<>();
        bloodSerumSampleReceived.setLabel("Blood/serum sample received");
        bloodSerumSampleReceived.setItems("Yes", "No");
        bloodSerumSampleReceived.setRequired(true);
        bloodSerumSampleReceived.setVisible(false);

        dateSpecimenReceivedBloodSerum = new DatePicker("Date specimen received");
        dateSpecimenReceivedBloodSerum.setMax(LocalDate.now());
        dateSpecimenReceivedBloodSerum.setRequired(true);
        dateSpecimenReceivedBloodSerum.setVisible(false);

        laboratoryIdBloodSerum = new TextField("Laboratory ID");
        laboratoryIdBloodSerum.setPlaceholder("Enter Lab ID");
        laboratoryIdBloodSerum.setVisible(false);

        sampleConditionBloodSerum = new RadioButtonGroup<>();
        sampleConditionBloodSerum.setLabel("Specimen condition");
        sampleConditionBloodSerum.setItems("Adequate", "Not Adequate");
        sampleConditionBloodSerum.setRequired(true);
        sampleConditionBloodSerum.setVisible(false);

        measlesSerologyResultBloodSerum = new RadioButtonGroup<>();
        measlesSerologyResultBloodSerum.setLabel("Measles serology result");
        measlesSerologyResultBloodSerum.setItems(
            "IgM Positive", "IgM Negative", "IGM Indeterminate", "Pending", "Not Done"
        );
        measlesSerologyResultBloodSerum.setRequired(true);
        measlesSerologyResultBloodSerum.setVisible(false);

        dateResultReleasedMeasles = new DatePicker("Date result released");
        dateResultReleasedMeasles.setMax(LocalDate.now());
        dateResultReleasedMeasles.setRequired(true);
        dateResultReleasedMeasles.setVisible(false);

        rubellaSerologyResultBloodSerum = new RadioButtonGroup<>();
        rubellaSerologyResultBloodSerum.setLabel("Rubella serology result");
        rubellaSerologyResultBloodSerum.setItems(
            "IgM Positive", "IgM Negative", "IGM Indeterminate", "Pending", "Not Done"
        );
        rubellaSerologyResultBloodSerum.setRequired(true);
        rubellaSerologyResultBloodSerum.setVisible(false);

        dateResultReleasedRubella = new DatePicker("Date result released");
        dateResultReleasedRubella.setMax(LocalDate.now());
        dateResultReleasedRubella.setRequired(true);
        dateResultReleasedRubella.setVisible(false);

        // Nasopharyngeal Swab section
        nasopharyngealSwabReceived = new RadioButtonGroup<>();
        nasopharyngealSwabReceived.setLabel("Nasopharyngeal swab received");
        nasopharyngealSwabReceived.setItems("Yes", "No");
        nasopharyngealSwabReceived.setRequired(true);
        nasopharyngealSwabReceived.setVisible(false);

        dateSpecimenReceivedNasopharyngealSwab = new DatePicker("Date specimen received");
        dateSpecimenReceivedNasopharyngealSwab.setMax(LocalDate.now());
        dateSpecimenReceivedNasopharyngealSwab.setRequired(true);
        dateSpecimenReceivedNasopharyngealSwab.setVisible(false);

        laboratoryIdNasopharyngealSwab = new TextField("Laboratory ID");
        laboratoryIdNasopharyngealSwab.setPlaceholder("Enter Lab ID");
        laboratoryIdNasopharyngealSwab.setVisible(false);

        sampleConditionNasopharyngealSwab = new RadioButtonGroup<>();
        sampleConditionNasopharyngealSwab.setLabel("Specimen condition");
        sampleConditionNasopharyngealSwab.setItems("Adequate", "Not Adequate");
        sampleConditionNasopharyngealSwab.setRequired(true);
        sampleConditionNasopharyngealSwab.setVisible(false);

        pcrResult = new RadioButtonGroup<>();
        pcrResult.setLabel("PCR result");
        pcrResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
        pcrResult.setRequired(true);
        pcrResult.setVisible(false);

        dateResultReleasedPcr = new DatePicker("Date result released");
        dateResultReleasedPcr.setMax(LocalDate.now());
        dateResultReleasedPcr.setRequired(true);
        dateResultReleasedPcr.setVisible(false);

        // Conditional logic for specimenCollected
        specimenCollected.addValueChangeListener(event -> {
            boolean show = "Yes".equals(event.getValue());
            dateSpecimenCollected.setVisible(show);
            sampleType.setVisible(show);
            dateSpecimenSent.setVisible(show);
            nameOfTestingLaboratory.setVisible(show);

            // Hide all specimen result sections if not "Yes"
            bloodSerumSampleReceived.setVisible(false);
            nasopharyngealSwabReceived.setVisible(false);
        });

        // Conditional logic for sampleType
        sampleType.addValueChangeListener(event -> {
            Set<String> selected = event.getValue();
            boolean hasBloodOrSerum = selected.contains("Blood") || selected.contains("Serum");
            boolean hasSwab = selected.contains("Nasopharyngeal swab");

            // Show/hide blood/serum section
            bloodSerumSampleReceived.setVisible(hasBloodOrSerum);

            // Show/hide swab section
            nasopharyngealSwabReceived.setVisible(hasSwab);

            // Show dateSpecimenSent if any specimen type is selected
            dateSpecimenSent.setVisible(selected.size() >= 1);
        });

        // Blood/Serum section logic
        bloodSerumSampleReceived.addValueChangeListener(event -> {
            boolean show = "Yes".equals(event.getValue());
            dateSpecimenReceivedBloodSerum.setVisible(show);
            laboratoryIdBloodSerum.setVisible(show);
            sampleConditionBloodSerum.setVisible(show);
            measlesSerologyResultBloodSerum.setVisible(show);
            dateResultReleasedMeasles.setVisible(show);
        });
        measlesSerologyResultBloodSerum.addValueChangeListener(event -> {
            String value = event.getValue();
            boolean show = "IgM Negative".equals(value) || "IGM Indeterminate".equals(value);
            rubellaSerologyResultBloodSerum.setVisible(show);
            dateResultReleasedRubella.setVisible(show);
        });

        // Nasopharyngeal Swab section logic
        nasopharyngealSwabReceived.addValueChangeListener(event -> {
            boolean show = "Yes".equals(event.getValue());
            dateSpecimenReceivedNasopharyngealSwab.setVisible(show);
            laboratoryIdNasopharyngealSwab.setVisible(show);
            sampleConditionNasopharyngealSwab.setVisible(show);
            pcrResult.setVisible(show);
            dateResultReleasedPcr.setVisible(show);
        });

        // Responsive steps
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("800px", 2)
        );

        // Add all fields to the form
        form.add(
            specimenCollected,
            dateSpecimenCollected,
            sampleType,
            dateSpecimenSent,
            nameOfTestingLaboratory,

            // Blood/Serum
            bloodSerumSampleReceived,
            dateSpecimenReceivedBloodSerum,
            laboratoryIdBloodSerum,
            sampleConditionBloodSerum,
            measlesSerologyResultBloodSerum,
            dateResultReleasedMeasles,
            rubellaSerologyResultBloodSerum,
            dateResultReleasedRubella,

            // Nasopharyngeal Swab
            nasopharyngealSwabReceived,
            dateSpecimenReceivedNasopharyngealSwab,
            laboratoryIdNasopharyngealSwab,
            sampleConditionNasopharyngealSwab,
            pcrResult,
            dateResultReleasedPcr
        );

        return form;
    }
}
