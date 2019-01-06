import QtQuick 2.9
import QtQuick.Controls 2.2
import QtQuick.Layouts 1.3

Page {
    id: hallPage
    width: 800
    height: 680
    property alias toolButton: toolButton
    property alias table5: table5
    property alias table4: table4
    property alias table3: table3
    property alias table2: table2
    property alias table1: table1
    title: "Sala"

    header: ToolBar {
        id: maintoolbar
        RowLayout {
            anchors.fill: parent
            ToolButton {
                id: toolButton
                text: qsTr("‹")
            }
        }
    }

    Button {
        id: table1
        x: 80
        y: 108
        width: 174
        height: 73
        text: qsTr("Stolik nr 1")
        font.pointSize: 10
    }

    Button {
        id: table4
        x: 80
        y: 360
        width: 263
        height: 131
        text: qsTr("Stolik nr 4")
        font.pointSize: 10
    }

    CheckBox {
        id: checkBox2
        x: 93
        y: 216
        width: 149
        height: 40
        text: qsTr("Przypisz do mnie")
        font.pointSize: 10
    }

    CheckBox {
        id: checkBox3
        x: 326
        y: 216
        width: 149
        height: 40
        text: qsTr("Przypisz do mnie")
        font.pointSize: 10
    }

    CheckBox {
        id: checkBox4
        x: 559
        y: 216
        width: 149
        height: 40
        text: qsTr("Przypisz do mnie")
        font.pointSize: 10
    }

    CheckBox {
        id: checkBox5
        x: 137
        y: 530
        width: 149
        height: 40
        text: qsTr("Przypisz do mnie")
        font.pointSize: 10
    }

    CheckBox {
        id: checkBox6
        x: 514
        y: 530
        width: 149
        height: 40
        text: qsTr("Przypisz do mnie")
        font.pointSize: 10
    }

    Button {
        id: table2
        x: 313
        y: 108
        width: 174
        height: 73
        text: qsTr("Stolik nr 2")
        font.pointSize: 10
    }

    Button {
        id: table3
        x: 546
        y: 108
        width: 174
        height: 73
        text: qsTr("Stolik nr 3")
        font.pointSize: 10
    }

    Button {
        id: table5
        x: 457
        y: 360
        width: 263
        height: 131
        text: qsTr("Stolik nr 5")
        font.pointSize: 10
    }

    TextField {
        id: textField
        x: 80
        y: 54
        width: 113
        height: 40
    }

    TextField {
        id: textField1
        x: 313
        y: 54
        width: 113
        height: 40
    }

    TextField {
        id: textField2
        x: 546
        y: 54
        width: 113
        height: 40
    }

    TextField {
        id: textField3
        x: 80
        y: 308
        width: 113
        height: 40
    }

    TextField {
        id: textField4
        x: 457
        y: 308
        width: 113
        height: 40
    }

    Text {
        id: element
        x: 80
        y: 34
        text: qsTr("Czas:")
        font.pixelSize: 12
    }

    Text {
        id: element1
        x: 313
        y: 34
        text: qsTr("Czas:")
        font.pixelSize: 12
    }

    Text {
        id: element2
        x: 546
        y: 34
        text: qsTr("Czas:")
        font.pixelSize: 12
    }

    Text {
        id: element3
        x: 80
        y: 288
        text: qsTr("Czas:")
        font.pixelSize: 12
    }

    Text {
        id: element4
        x: 457
        y: 288
        text: qsTr("Czas:")
        font.pixelSize: 12
    }
}
