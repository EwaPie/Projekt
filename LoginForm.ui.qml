import QtQuick 2.9
import QtQuick.Controls 2.2
import QtQuick.Layouts 1.3

Page {
    id: loginPage
    width: 640
    height: 480
    title: "Strona Logowania"

    TextField {
        id: password
        x: 173
        y: 179
        width: 294
        height: 40
        text: qsTr("")
        placeholderText: "Hasło"
        echoMode: TextInput.Password
    }

    Button {
        id: login_button
        x: 251
        y: 302
        width: 139
        height: 50
        text: qsTr("Zaloguj się")
    }

    TextField {
        id: login
        x: 173
        y: 111
        width: 294
        height: 40
        text: qsTr("")
        placeholderText: "Użytkownik"
    }
}
