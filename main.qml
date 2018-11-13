import QtQuick 2.9
import QtQuick.Controls 2.2
import QtQuick.Layouts 1.3

ApplicationWindow {
    id: window
    visible: true
    width: 640
    height: 480
    title: qsTr("Najlepsza Aplikacja")

    header: ToolBar {
        RowLayout {
          anchors.fill: parent
          ToolButton {
              text: qsTr("‹")
              onClicked: stackview.push(starting_page)

          }
      }
    }

    StackView {
        id: stackview
        initialItem: statistics_page
    }

    Component {
        id: login_page
        LoginForm {}
    }

    Component {
        id: starting_page
        StartingPageForm {}
    }

    Component {
        id: users_page
        UsersForm {}
    }

    Component {
        id: statistics_page
        StatisticsForm {}
    }

}
