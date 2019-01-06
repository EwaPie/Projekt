import QtQuick 2.9
import QtQuick.Controls 2.2
import QtQuick.Layouts 1.3

Page {
    id: startPage
    width: 800
    height: 680
    property alias menu_button: menu_button
    property alias hall_button: hall_button
    property alias statisticks_button: statisticks_button
    property alias users_button: users_button
    property alias discounts_button: discounts_button
    title: 'Strona główna'

    header: ToolBar {
        id: maintoolbar
        RowLayout {
          anchors.fill: parent
          ToolButton {
              text: qsTr("‹")
          }
      }
    }

    Button {
        id: statisticks_button
        x: 86
        y: 380
        width: 311
        height: 120
        text: qsTr("Statystyki")
        Layout.rowSpan: 2
        Layout.preferredHeight: 60
        Layout.preferredWidth: 236
        font.pointSize: 12
        Layout.fillHeight: true
        Layout.fillWidth: true
    }

    Button {
        id: menu_button
        x: 410
        y: 317
        width: 311
        height: 183
        text: qsTr("Menu")
        Layout.rowSpan: 3
        Layout.preferredHeight: 60
        Layout.preferredWidth: 236
        spacing: 1
        font.pointSize: 12
        Layout.fillHeight: true
        Layout.fillWidth: true
    }

    Button {
        id: users_button
        x: 86
        y: 254
        width: 311
        height: 120
        text: qsTr("Użytkownicy")
        Layout.rowSpan: 3
        Layout.preferredHeight: 60
        Layout.preferredWidth: 236
        font.pointSize: 12
        Layout.fillHeight: true
        Layout.fillWidth: true
    }

    Button {
        id: hall_button
        x: 410
        y: 128
        width: 311
        height: 183
        text: qsTr("Sala")
        Layout.rowSpan: 3
        Layout.preferredHeight: 60
        Layout.preferredWidth: 236
        font.family: "Arial"
        spacing: 5
        focusPolicy: Qt.ClickFocus
        font.pointSize: 12
        Layout.fillHeight: true
        Layout.fillWidth: true
    }

    Button {
        id: discounts_button
        x: 85
        y: 128
        width: 311
        height: 120
        text: qsTr("Rabaty")
        Layout.rowSpan: 2
        Layout.preferredHeight: 60
        Layout.preferredWidth: 236
        font.pointSize: 12
        Layout.fillHeight: true
        Layout.fillWidth: true
        z: 1
    }
}
