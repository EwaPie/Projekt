import QtQuick 2.9
import QtQuick.Controls 2.2
import QtQuick.Layouts 1.3

Page {
    id: statisticsPage
    width: 640
    height: 480
    title: "Statystyki"

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
            text: qsTr("Statystyki pracowników")
            autoExclusive: false
            checked: false
        }

        TabButton {
            x: 148
            y: 0
            width: 150
            height: 52
            text: qsTr("Statystyki restauracji")
        }
    }

    StackLayout {
        anchors.fill: parent
        currentIndex: tabBar.currentIndex

        Item {
            id: stat_employeesTab

            ComboBox {
                id: comboBox
                x: 29
                y: 64
                width: 588
                height: 51
                displayText: "Wybierz użytkownika"
            }

            TextField {
                id: textField
                x: 465
                y: 150
                width: 110
                height: 42
                text: qsTr("25")
                horizontalAlignment: Text.AlignHCenter
                font.pointSize: 9
                leftPadding: 0
                padding: 6
                rightPadding: 0
                readOnly: true
            }

            Label {
                id: label
                x: 29
                y: 154
                width: 183
                height: 33
                text: qsTr("Ilość sprzedanych posiłków")
                font.pointSize: 9
                verticalAlignment: Text.AlignVCenter
                font.capitalization: Font.MixedCase
            }

            Label {
                id: label1
                x: 29
                y: 279
                width: 183
                height: 33
                text: qsTr("Ilość zarobionych pieniędzy")
                font.capitalization: Font.MixedCase
                font.pointSize: 9
                verticalAlignment: Text.AlignVCenter
            }

            TextField {
                id: textField1
                x: 465
                y: 275
                width: 110
                height: 42
                text: qsTr("600,00zł")
                horizontalAlignment: Text.AlignHCenter
                font.pointSize: 9
                readOnly: true
                rightPadding: 0
                padding: 6
                leftPadding: 0
            }

            Label {
                id: label2
                x: 29
                y: 217
                width: 183
                height: 33
                text: qsTr("Ilość obsłużonych stolików")
                font.capitalization: Font.MixedCase
                font.pointSize: 9
                verticalAlignment: Text.AlignVCenter
            }

            TextField {
                id: textField2
                x: 465
                y: 213
                width: 110
                height: 42
                text: qsTr("10")
                horizontalAlignment: Text.AlignHCenter
                rightPadding: 0
                readOnly: true
                padding: 6
                font.pointSize: 9
                leftPadding: 0
            }

            Label {
                id: label3
                x: 29
                y: 338
                width: 221
                height: 33
                text: qsTr("Średnia ocena zadowolenia klientów")
                verticalAlignment: Text.AlignVCenter
                font.capitalization: Font.MixedCase
                font.pointSize: 9
            }

            TextField {
                id: textField3
                x: 465
                y: 334
                width: 110
                height: 42
                text: qsTr("4.5")
                rightPadding: 0
                readOnly: true
                padding: 6
                horizontalAlignment: Text.AlignHCenter
                font.pointSize: 9
                leftPadding: 0
            }
        }
    }
}
