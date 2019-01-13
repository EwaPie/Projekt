import QtQuick 2.9
import QtQuick.Controls 2.2
import QtQuick.Layouts 1.3

Page {
    id: statisticsPage
    width: 800
    height: 680
    property alias toolButton: toolButton
    title: "Statystyki"

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

    TabBar {
        id: tabBar
        x: 0
        y: 0
        width: 296
        height: 45
        currentIndex: 0

        TabButton {
            id: employees_stats_tab
            x: 0
            y: 0
            width: 175
            height: 52
            text: qsTr("Statystyki pracowników")
            font.pointSize: 9
        }

        TabButton {
            id: restaurant_stats_tab
            x: 148
            y: 0
            width: 175
            height: 52
            text: qsTr("Statystyki restauracji")
            font.pointSize: 9
        }
    }

    StackLayout {
        anchors.rightMargin: 1
        anchors.bottomMargin: 0
        anchors.leftMargin: -1
        anchors.topMargin: 0
        anchors.fill: parent
        currentIndex: tabBar.currentIndex

        Item {
            id: stat_employeesTab

            ComboBox {
                id: comboBox
                x: 60
                y: 86
                width: 676
                height: 74
                displayText: "Wybierz użytkownika"
            }

            GridLayout {
                x: 81
                y: 199
                width: 635
                height: 363
                visible: true
                columnSpacing: 160
                rowSpacing: 20
                rows: 4
                columns: 2

                Text {
                    id: measure_1
                    width: 250
                    height: 33
                    text: qsTr("Ilość sprzedanych posiłków")
                    Layout.rowSpan: 1
                    Layout.preferredHeight: 33
                    Layout.preferredWidth: 221
                    verticalAlignment: Text.AlignVCenter
                    font.pixelSize: 14
                }

                TextField {
                    id: number_of_sold_meals
                    text: qsTr("25")
                    Layout.preferredHeight: 42
                    Layout.preferredWidth: 110
                    horizontalAlignment: Text.AlignHCenter
                    font.pointSize: 9
                    leftPadding: 0
                    padding: 6
                    rightPadding: 0
                    readOnly: true
                }

                Text {
                    id: measure_2
                    text: qsTr("Ilość obsłużonych stolików")
                    Layout.preferredHeight: 33
                    Layout.preferredWidth: 221
                    font.pixelSize: 14
                    verticalAlignment: Text.AlignVCenter
                }

                TextField {
                    id: number_of_served_tabels
                    text: qsTr("10")
                    Layout.preferredHeight: 42
                    Layout.preferredWidth: 110
                    horizontalAlignment: Text.AlignHCenter
                    rightPadding: 0
                    readOnly: true
                    padding: 6
                    font.pointSize: 9
                    leftPadding: 0
                }

                Text {
                    id: measure_3
                    text: qsTr("Ilość zarobionych pieniędzy")
                    Layout.preferredHeight: 33
                    Layout.preferredWidth: 221
                    font.pixelSize: 14
                    verticalAlignment: Text.AlignVCenter
                }

                TextField {
                    id: amount_of_earned_money
                    text: qsTr("600,00zł")
                    Layout.preferredHeight: 42
                    Layout.preferredWidth: 110
                    horizontalAlignment: Text.AlignHCenter
                    font.pointSize: 9
                    readOnly: true
                    rightPadding: 0
                    padding: 6
                    leftPadding: 0
                }

                Text {
                    id: measure_4
                    text: qsTr("Średnia ocena zadowolenia klientów")
                    Layout.preferredHeight: 33
                    Layout.preferredWidth: 221
                    font.pixelSize: 14
                    verticalAlignment: Text.AlignVCenter
                }

                TextField {
                    id: avg_satisfaction
                    text: qsTr("4.5")
                    Layout.preferredHeight: 42
                    Layout.preferredWidth: 110
                    rightPadding: 0
                    readOnly: true
                    padding: 6
                    horizontalAlignment: Text.AlignHCenter
                    font.pointSize: 9
                    leftPadding: 0
                }
            }
        }

        Item {
            id: stat_restaurant
            width: 640
            height: 480

            GridLayout {
                x: 74
                y: 100
                width: 652
                height: 317
                visible: true
                rows: 5

                Text {
                    id: measure_5
                    text: qsTr("Ilość zarobionych pieniędzy")
                    Layout.preferredHeight: 33
                    Layout.preferredWidth: 221
                    font.pixelSize: 13
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
                    id: measure_6
                    text: qsTr("Ilość obsłużonych stolików")
                    Layout.preferredHeight: 33
                    Layout.preferredWidth: 221
                    font.pixelSize: 13
                    verticalAlignment: Text.AlignVCenter
                }

                TextField {
                    id: sum_of_earned_money1
                    text: qsTr("256,00zł")
                    rightPadding: 0
                    readOnly: true
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
                    font.pixelSize: 13
                    verticalAlignment: Text.AlignVCenter
                }

                TextField {
                    id: best_meal
                    text: qsTr("Frytki")
                    rightPadding: 0
                    readOnly: true
                    Layout.preferredHeight: 42
                    Layout.preferredWidth: 110
                    horizontalAlignment: Text.AlignHCenter
                    padding: 6
                    leftPadding: 0
                    font.pointSize: 9
                }

                Text {
                    id: measure_8
                    text: qsTr("Najlepszy pracownik")
                    Layout.preferredHeight: 33
                    Layout.preferredWidth: 221
                    font.pixelSize: 13
                    verticalAlignment: Text.AlignVCenter
                }

                TextField {
                    id: best_employee
                    text: qsTr("Morgan Freeman")
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
                    id: measure_9
                    text: qsTr("Najgorszy pracownik")
                    Layout.preferredHeight: 33
                    Layout.preferredWidth: 221
                    font.pixelSize: 13
                    verticalAlignment: Text.AlignVCenter
                }

                TextField {
                    id: worst_employee
                    text: qsTr("Hello")
                    Layout.fillWidth: false
                    rightPadding: 0
                    readOnly: true
                    Layout.preferredHeight: 42
                    Layout.preferredWidth: 110
                    horizontalAlignment: Text.AlignHCenter
                    padding: 6
                    leftPadding: 0
                    font.pointSize: 9
                }
                rowSpacing: 20
                columns: 2
                columnSpacing: 160
            }

            Button {
                id: button
                x: 259
                y: 468
                width: 283
                height: 83
                text: qsTr("Pobierz pełen raport ")
                font.pointSize: 10
            }
        }
    }
}
