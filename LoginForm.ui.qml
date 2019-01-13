import QtQuick 2.9
import QtQuick.Controls 2.2
import QtQuick.Layouts 1.3

Page {
    id: loginPage
    width: 800
    height: 680
    property alias login_button: login_button
    property alias mouseArea: mouseArea
    title: "Strona Logowania"

    Button {
        id: login_button
        x: 299
        y: 375
        width: 203
        height: 90
        text: qsTr("Zaloguj się")

    }

    TextField {
        id: password
        x: 200
        y: 233
        width: 400
        height: 59
        text: qsTr("")
        Layout.columnSpan: 3

        placeholderText: "Hasło"
        echoMode: TextInput.Password

        selectByMouse: true
        MouseArea {
            anchors.fill: parent
            cursorShape: Qt.IBeamCursor
            acceptedButtons: Qt.NoButton
        }
    }

    TextField {
        id: login
        x: 200
        y: 137
        width: 400
        height: 55
        Layout.columnSpan: 3
        placeholderText: "Użytkownik"

        selectByMouse: true
        MouseArea {
            id: mouseArea
            anchors.fill: parent
            cursorShape: Qt.IBeamCursor
            acceptedButtons: Qt.NoButton
        }
    }
}
