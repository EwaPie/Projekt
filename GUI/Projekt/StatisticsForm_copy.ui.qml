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
            id: stat_restaurant

            GridLayout {
                x: 32
                y: 86
                width: 577
                height: 308
                columnSpacing: 160
                rowSpacing: 20
                rows: 5
                columns: 2

                Text {
                    id: measure_3
                    text: qsTr("Ilość zarobionych pieniędzy")
                    Layout.preferredHeight: 33
                    Layout.preferredWidth: 221
                    font.pixelSize: 12
                    verticalAlignment: Text.AlignVCenter
                }

                TextField {
                    id: sum_of_earned_money
                    text: qsTr("600,00zł")
                    readOnly: true
                    rightPadding: 0
                    Layout.preferredHeight: 42
                    Layout.preferredWidth: 110
                    horizontalAlignment: Text.AlignHCenter
                    padding: 6
                    leftPadding: 0
                    font.pointSize: 9
                }

                Text {
                    id: measure_5
                    text: qsTr("Ilość obsłużonych stolików")
                    Layout.preferredHeight: 33
                    Layout.preferredWidth: 221
                    font.pixelSize: 12
                    verticalAlignment: Text.AlignVCenter
                }

                TextField {
                    id: sum_of_earned_money1
                    text: qsTr("600,00zł")
                    readOnly: true
                    rightPadding: 0
                    Layout.preferredHeight: 42
                    Layout.preferredWidth: 110
                    horizontalAlignment: Text.AlignHCenter
                    padding: 6
                    leftPadding: 0
                    font.pointSize: 9
                }

                Text {
                    id: measure_7
                    text: qsTr("Najlepiej sprzedające się danie")
                    Layout.preferredHeight: 33
                    Layout.preferredWidth: 221
                    font.pixelSize: 12
                    verticalAlignment: Text.AlignVCenter
                }

                TextField {
                    id: best_meal
                    text: qsTr("Frytki")
                    rightPadding: 0
                    readOnly: true
                    Layout.preferredHeight: 42
                    Layout.preferredWidth: 142
                    horizontalAlignment: Text.AlignHCenter
                    padding: 6
                    leftPadding: 0
                    font.pointSize: 9
                }

                Text {
                    id: measure_6
                    text: qsTr("Najlepszy pracownik")
                    Layout.preferredHeight: 33
                    Layout.preferredWidth: 221
                    font.pixelSize: 12
                    verticalAlignment: Text.AlignVCenter
                }

                TextField {
                    id: best_meal1
                    text: qsTr("Morgan Freeman")
                    Layout.fillWidth: false
                    readOnly: true
                    rightPadding: 0
                    Layout.preferredHeight: 42
                    Layout.preferredWidth: 142
                    horizontalAlignment: Text.AlignHCenter
                    padding: 6
                    leftPadding: 0
                    font.pointSize: 9
                }

                Text {
                    id: measure_4
                    text: qsTr("Najgorszy pracownik")
                    Layout.preferredHeight: 33
                    Layout.preferredWidth: 221
                    font.pixelSize: 12
                    verticalAlignment: Text.AlignVCenter
                }

                TextField {
                    id: best_meal2
                    text: qsTr("Drabik")
                    readOnly: true
                    rightPadding: 0
                    Layout.preferredHeight: 42
                    Layout.preferredWidth: 142
                    horizontalAlignment: Text.AlignHCenter
                    padding: 6
                    leftPadding: 0
                    font.pointSize: 9
                }
            }


        }
    }
}
