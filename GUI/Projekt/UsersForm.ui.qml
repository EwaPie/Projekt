import QtQuick 2.9
import QtQuick.Controls 2.2
import QtQuick.Layouts 1.3

Page {
    id: userPage
    width: 640
    height: 480
    title: "Użytkownicy"

    TabBar {
        id: tabBar
        x: 0
        y: 0
        width: 296
        height: 45

        TabButton {
            x: 0
            y: 0
            width: 150
            height: 52
            text: qsTr("Stwórz użytkownika")
        }

        TabButton {
            x: 148
            y: 0
            width: 150
            height: 52
            text: qsTr("Usuń użytkownika")
        }
    }
        StackLayout {
            anchors.fill: parent
            currentIndex: tabBar.currentIndex

            Item {
                id: createTab
                TextField {
                    id: add_password
                    x: 16
                    y: 326
                    width: 265
                    height: 50
                    text: ""
                    placeholderText: "Hasło"
                }

                TextField {
                    id: add_login
                    x: 16
                    y: 239
                    width: 265
                    height: 50
                    text: ""
                    placeholderText: "Nazwa użytkownika"
                }

                ComboBox {
                    id: select_role
                    x: 327
                    y: 62
                    width: 285
                    height: 64
                    displayText: "Wybierz role"
                    textRole: ""
                }

                TextField {
                    id: add_name
                    x: 16
                    y: 76
                    width: 265
                    height: 50
                    clip: false
                    placeholderText: "Imię"
                }

                TextField {
                    id: add_lastname
                    x: 16
                    y: 156
                    width: 265
                    height: 50
                    placeholderText: "Nazwisko"
                }

                Button {
                    id: add_user
                    x: 387
                    y: 292
                    width: 207
                    height: 84
                    text: qsTr("Dodaj uzytkownika")
                }

            }

            Item {
                id: delete_tab

                ComboBox {
                    id: select_user
                    x: 21
                    y: 112
                    width: 590
                    height: 71
                    displayText: "Wybierz użytkownika"
                    textRole: ""
                }

                Button {
                    id: delete_user
                    x: 387
                    y: 292
                    width: 207
                    height: 84
                    text: qsTr("Usuń uzytkownika")
                }

        }
    }

}








