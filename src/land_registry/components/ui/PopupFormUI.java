package land_registry.components.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import land_registry.components.ui.utils.FormNode;
import land_registry.components.ui.utils.FormNodeGroup;

public class PopupFormUI extends PopupWindowUI {
    private final int FORM_NODE_PADDING = 30;
    private VBox formContainer;
    private FormNodeGroup formNodeGroup;

    public PopupFormUI() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public PopupFormUI(int width, int height) {
        super(width, height);
        initForm();
    }

    private void initForm() {
        formContainer = new VBox();
        formNodeGroup = new FormNodeGroup();
        contentPanel.getChildren().add(formContainer);
    }

    public void addFormNode(String name, Node node) {
        this.addFormNode(new FormNode(name, node));
    }

    public void addFormNode(FormNode formNode) {
        formNodeGroup.getFormNodes().add(formNode);
    }

    public void renderFormNode(FormNode formNode) {
        HBox formNodeContainer = new HBox();
        StackPane keyWrapperPanel = new StackPane();
        StackPane nodeWrapperPanel = new StackPane();

        HBox.setHgrow(keyWrapperPanel, Priority.ALWAYS);
        HBox.setHgrow(nodeWrapperPanel, Priority.ALWAYS);
        VBox.setVgrow(formNodeContainer, Priority.ALWAYS);

        keyWrapperPanel.setPrefWidth(0);
        keyWrapperPanel.setAlignment(Pos.CENTER_LEFT);
        keyWrapperPanel.getChildren().add(new Label(formNode.getName()));
        keyWrapperPanel.setPadding(new Insets(0, FORM_NODE_PADDING, 0, FORM_NODE_PADDING));

        nodeWrapperPanel.setAlignment(Pos.CENTER_LEFT);
        nodeWrapperPanel.getChildren().add(formNode.getNode());
        nodeWrapperPanel.setPadding(new Insets(0, FORM_NODE_PADDING, 0, FORM_NODE_PADDING));

        formNodeContainer.getChildren().addAll(keyWrapperPanel, nodeWrapperPanel);
        formContainer.getChildren().add(formNodeContainer);
    }

    public void renderFormNodes() {
        for (FormNode formNode : formNodeGroup.getFormNodes()) {
            renderFormNode(formNode);
        }
    }

    public static PopupFormUI createPopupForm(int width, int height) {
        return new PopupFormUI(width, height);
    }
}
