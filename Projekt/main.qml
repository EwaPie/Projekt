import QtQuick 2.9
import QtQuick.Controls 2.2
import QtQuick.Layouts 1.3

ApplicationWindow {

    id: window
    visible: true
    width: 800
    height: 680
    title: qsTr("Aplikacja")

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
        initialItem: login_page

    }

    Component {
        id: login_page
        LoginForm {}
    }

    Component {
        id: starting_page
        StartingPageForm {
            menu_button.onClicked: {
                stackview.push(menu_page)
            }
            hall_button.onClicked: {
                stackview.push(hall_page)
            }
            statisticks_button.onClicked: {
                stackview.push(statistics_page)
            }
            users_button.onClicked: {
                stackview.push(users_page)
            }
            discounts_button.onClicked: {
                stackview.push(discounts_page)
            }
        }
    }

    Component {
        id: users_page
        UsersForm {}
    }

    Component {
        id: statistics_page
        StatisticsForm {}
    }

    Component {
        id: discounts_page
        DiscountsForm {}
    }

    Component {
        id: hall_page
        HallForm {}
    }

    Component {
        id: menu_page
        MenuForm {}
    }

    function load_page(text){
     switch(text){
     case 'Rabaty':
         stackview.push(discounts_page);
         break;
     case 'Sala':
         stackview.push(hall_page);
         break;
     case 'Menu':
         stackview.push(menu_page);
         break;
     case 'Statystyki':
         stackview.push(statistics_page);
         break;
     case 'Uzytkownicy':
         stackview.push(users_page);
         break;
     }
 }

}
