export default function ($stateProvider, $urlRouterProvider) {
    'ngInject';

    $stateProvider
        .state('players', {
               url: '/players',
               templateUrl: 'app/players/players.html',
               controller: 'playersController',
               controllerAs: 'vm',
               ncyBreadcrumb: {
                   label: 'Players'
               }
            })
        .state('player-details', {
            url: '/players/:id',
            templateUrl: 'app/players/details/player-details.html',
            controller: 'playerDetailsController',
            controllerAs: 'vm',
            ncyBreadcrumb: {
                label: '{{vm.player.name}}',
                parent: 'players'
            }
        })
        .state('guitar-details', {
            url: '/guitars/:id',
            templateUrl: 'app/guitars/details/guitar-details.html',
            controller: 'guitarDetailsController',
            controllerAs: 'vm',
            ncyBreadcrumb: {
                label: '{{vm.guitar.model}}'
            }
        })
        .state('admin', {
            url: '/admin',
            templateUrl: 'app/admin/admin.html',
            controller: 'adminController',
            controllerAs: 'vm',
            ncyBreadcrumb: {
                label: 'Admin'
            }
        });

    $urlRouterProvider.otherwise('/players');
}