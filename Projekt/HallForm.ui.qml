import QtQuick 2.9
import QtQuick.Controls 2.2
import QtQuick.Layouts 1.3

Page {
    id: hallPage
    width: 800
    height: 680
    title: "Sala"

    Button {
        id: button5
        x: 80
        y: 108
        width: 174
        height: 73
        text: qsTr("Stolik nr 1")
        font.pointSize: 10
    }

    Button {
        id: button7
        x: 80
        y: 335
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
        y: 505
        width: 149
        height: 40
        text: qsTr("Przypisz do mnie")
        font.pointSize: 10
    }

    CheckBox {
        id: checkBox6
        x: 514
        y: 505
        width: 149
        height: 40
        text: qsTr("Przypisz do mnie")
        font.pointSize: 10
    }

    Button {
        id: button6
        x: 313
        y: 108
        width: 174
        height: 73
        text: qsTr("Stolik nr 2")
        font.pointSize: 10
    }

    Button {
        id: button9
        x: 546
        y: 108
        width: 174
        height: 73
        text: qsTr("Stolik nr 3")
        font.pointSize: 10
    }

    Button {
        id: button8
        x: 457
        y: 335
        width: 263
        height: 131
        text: qsTr("Stolik nr 5")
        font.pointSize: 10
    }
}
