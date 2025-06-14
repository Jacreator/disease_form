package com.jacreator.disease_form.views.lassa_fever;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class LassaFeverLaboratoryInformationView extends VerticalLayout {
// State for conditional fields
    private String specimenCollectedValue = null;
    private List<String> specimenTypeValue = null;
    private String bloodSpecimenReceivedValue = null;
    private String bloodPcrResultValue = null;
    private String breastmilkSpecimenReceivedValue = null;
    private String breastmilkPcrResultValue = null;

    // Form fields that need to be shown/hidden
    private DatePicker dateSpecimenCollected, dateSpecimenSent;
    private CheckboxGroup<String> specimenType;
    private ComboBox<String> nameOfTestingLaboratory;
    private TextField whySpecimenNotCollected;

    // Blood
    private RadioButtonGroup<String> bloodSpecimenReceived;
    private DatePicker bloodDateSpecimenReceived, bloodDateResultReleased;
    private RadioButtonGroup<String> bloodSpecimenCondition;
    private TextField bloodLaboratoryId, reasonBloodPcrNotDone;
    private RadioButtonGroup<String> bloodPcrResult;

    // Breastmilk
    private RadioButtonGroup<String> breastmilkSpecimenReceived;
    private DatePicker breastmilkDateSpecimenReceived, breastmilkDateResultReleased;
    private RadioButtonGroup<String> breastmilkSpecimenCondition;
    private TextField breastmilkLaboratoryId, reasonBreastmilkPcrNotDone;
    private RadioButtonGroup<String> breastmilkPcrResult;

    public LassaFeverLaboratoryInformationView() {
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
        specimenCollected.setItems("Yes", "No");
        specimenCollected.setRequired(true);

        // Date specimen collected
        dateSpecimenCollected = new DatePicker("Date specimen collected");
        dateSpecimenCollected.setMax(LocalDate.now());
        dateSpecimenCollected.setRequired(true);
        dateSpecimenCollected.setVisible(false);

        // Type of specimen collected
        specimenType = new CheckboxGroup<>();
        specimenType.setLabel("Type of specimen collected");
        specimenType.setItems("Blood", "Breast milk");
        specimenType.setRequired(true);
        specimenType.setVisible(false);

        // Name of testing laboratory
        nameOfTestingLaboratory = new ComboBox<>("Name of testing laboratory");
        nameOfTestingLaboratory.setItems(laboratoryOptions);
        nameOfTestingLaboratory.setPlaceholder("Select Laboratory Name");
        nameOfTestingLaboratory.setRequired(true);
        nameOfTestingLaboratory.setVisible(false);

        // Date specimen sent
        dateSpecimenSent = new DatePicker("Date specimen sent");
        dateSpecimenSent.setMax(LocalDate.now());
        dateSpecimenSent.setRequired(true);
        dateSpecimenSent.setVisible(false);

        // Why was specimen not collected?
        whySpecimenNotCollected = new TextField("Why was specimen not collected?");
        whySpecimenNotCollected.setPlaceholder("Enter reason");
        whySpecimenNotCollected.setRequired(true);
        whySpecimenNotCollected.setVisible(false);

        // Blood section
        bloodSpecimenReceived = new RadioButtonGroup<>();
        bloodSpecimenReceived.setLabel("Blood specimen received");
        bloodSpecimenReceived.setItems("Yes", "No");
        bloodSpecimenReceived.setRequired(true);
        bloodSpecimenReceived.setVisible(false);

        bloodDateSpecimenReceived = new DatePicker("Date specimen received");
        bloodDateSpecimenReceived.setMax(LocalDate.now());
        bloodDateSpecimenReceived.setRequired(true);
        bloodDateSpecimenReceived.setVisible(false);

        bloodSpecimenCondition = new RadioButtonGroup<>();
        bloodSpecimenCondition.setLabel("Specimen condition");
        bloodSpecimenCondition.setItems("Adequate", "Not adequate");
        bloodSpecimenCondition.setRequired(true);
        bloodSpecimenCondition.setVisible(false);

        bloodLaboratoryId = new TextField("Laboratory ID");
        bloodLaboratoryId.setPlaceholder("Enter lab ID");
        bloodLaboratoryId.setRequired(true);
        bloodLaboratoryId.setVisible(false);

        bloodPcrResult = new RadioButtonGroup<>();
        bloodPcrResult.setLabel("PCR/RT-PCR result");
        bloodPcrResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not done");
        bloodPcrResult.setRequired(true);
        bloodPcrResult.setVisible(false);

        reasonBloodPcrNotDone = new TextField("Why was test not done?");
        reasonBloodPcrNotDone.setPlaceholder("Enter reason");
        reasonBloodPcrNotDone.setRequired(true);
        reasonBloodPcrNotDone.setVisible(false);

        bloodDateResultReleased = new DatePicker("Date result released");
        bloodDateResultReleased.setMax(LocalDate.now());
        bloodDateResultReleased.setRequired(true);
        bloodDateResultReleased.setVisible(false);

        // Breastmilk section
        breastmilkSpecimenReceived = new RadioButtonGroup<>();
        breastmilkSpecimenReceived.setLabel("Breast milk specimen received");
        breastmilkSpecimenReceived.setItems("Yes", "No");
        breastmilkSpecimenReceived.setRequired(true);
        breastmilkSpecimenReceived.setVisible(false);

        breastmilkDateSpecimenReceived = new DatePicker("Date specimen received");
        breastmilkDateSpecimenReceived.setMax(LocalDate.now());
        breastmilkDateSpecimenReceived.setRequired(true);
        breastmilkDateSpecimenReceived.setVisible(false);

        breastmilkSpecimenCondition = new RadioButtonGroup<>();
        breastmilkSpecimenCondition.setLabel("Specimen condition");
        breastmilkSpecimenCondition.setItems("Adequate", "Not adequate");
        breastmilkSpecimenCondition.setRequired(true);
        breastmilkSpecimenCondition.setVisible(false);

        breastmilkLaboratoryId = new TextField("Laboratory ID");
        breastmilkLaboratoryId.setPlaceholder("Enter lab ID");
        breastmilkLaboratoryId.setRequired(true);
        breastmilkLaboratoryId.setVisible(false);

        breastmilkPcrResult = new RadioButtonGroup<>();
        breastmilkPcrResult.setLabel("PCR/RT-PCR result");
        breastmilkPcrResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not done");
        breastmilkPcrResult.setRequired(true);
        breastmilkPcrResult.setVisible(false);

        reasonBreastmilkPcrNotDone = new TextField("Why was test not done?");
        reasonBreastmilkPcrNotDone.setPlaceholder("Enter reason");
        reasonBreastmilkPcrNotDone.setRequired(true);
        reasonBreastmilkPcrNotDone.setVisible(false);

        breastmilkDateResultReleased = new DatePicker("Date result released");
        breastmilkDateResultReleased.setMax(LocalDate.now());
        breastmilkDateResultReleased.setRequired(true);
        breastmilkDateResultReleased.setVisible(false);

        // --- Conditional logic ---
        specimenCollected.addValueChangeListener(event -> {
            boolean yes = "Yes".equals(event.getValue());
            dateSpecimenCollected.setVisible(yes);
            specimenType.setVisible(yes);
            nameOfTestingLaboratory.setVisible(yes);
            dateSpecimenSent.setVisible(yes);

            whySpecimenNotCollected.setVisible(!yes);

            // Hide all specimen result sections if not "Yes"
            bloodSpecimenReceived.setVisible(false);
            breastmilkSpecimenReceived.setVisible(false);
        });

        specimenType.addValueChangeListener(event -> {
            Set<String> selected = event.getValue();
            boolean hasBlood = selected.contains("Blood");
            boolean hasBreastmilk = selected.contains("Breast milk");

            // Show/hide blood section
            bloodSpecimenReceived.setVisible(hasBlood);

            // Show/hide breastmilk section
            breastmilkSpecimenReceived.setVisible(hasBreastmilk);
        });

        // Blood section logic
        bloodSpecimenReceived.addValueChangeListener(event -> {
            boolean yes = "Yes".equals(event.getValue());
            bloodDateSpecimenReceived.setVisible(yes);
            bloodSpecimenCondition.setVisible(yes);
            bloodLaboratoryId.setVisible(yes);
            bloodPcrResult.setVisible(yes);
        });

        bloodPcrResult.addValueChangeListener(event -> {
            String value = event.getValue();
            boolean notDone = "Not done".equalsIgnoreCase(value);
            boolean showDate = Arrays.asList("Positive", "Negative", "Indeterminate").contains(value);

            reasonBloodPcrNotDone.setVisible(notDone);
            bloodDateResultReleased.setVisible(showDate);
        });

        // Breastmilk section logic
        breastmilkSpecimenReceived.addValueChangeListener(event -> {
            boolean yes = "Yes".equals(event.getValue());
            breastmilkDateSpecimenReceived.setVisible(yes);
            breastmilkSpecimenCondition.setVisible(yes);
            breastmilkLaboratoryId.setVisible(yes);
            breastmilkPcrResult.setVisible(yes);
        });

        breastmilkPcrResult.addValueChangeListener(event -> {
            String value = event.getValue();
            boolean notDone = "Not done".equalsIgnoreCase(value);
            boolean showDate = Arrays.asList("Positive", "Negative", "Indeterminate").contains(value);

            reasonBreastmilkPcrNotDone.setVisible(notDone);
            breastmilkDateResultReleased.setVisible(showDate);
        });

        // Responsive steps
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("600px", 2),
            new FormLayout.ResponsiveStep("700px", 3));

        // Add all fields to the form
        form.add(
            specimenCollected,
            dateSpecimenCollected,
            specimenType,
            nameOfTestingLaboratory,
            dateSpecimenSent,
            whySpecimenNotCollected,

            // Blood
            bloodSpecimenReceived,
            bloodDateSpecimenReceived,
            bloodSpecimenCondition,
            bloodLaboratoryId,
            bloodPcrResult,
            reasonBloodPcrNotDone,
            bloodDateResultReleased,

            // Breastmilk
            breastmilkSpecimenReceived,
            breastmilkDateSpecimenReceived,
            breastmilkSpecimenCondition,
            breastmilkLaboratoryId,
            breastmilkPcrResult,
            reasonBreastmilkPcrNotDone,
            breastmilkDateResultReleased
        );

        return form;
    }
}
