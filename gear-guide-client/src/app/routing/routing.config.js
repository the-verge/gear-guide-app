export default function ($stateProvider, $urlRouterProvider) {
    'ngInject';

    $stateProvider
        .state('players', {
               url: '/players',
               templateUrl: 'app/players/players.html',
               controller: 'playerController',
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
                templateUrl: 'app/players/details/guitar-details.html',
                controller: 'guitarDetailsController',
                controllerAs: 'vm',
                ncyBreadcrumb: {
                    label: '{{vm.guitar.name}}'
                }
            });

    $urlRouterProvider.otherwise('/players');
}