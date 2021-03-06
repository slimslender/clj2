 (defproject clj2 "0.1.8-SNAPSHOT"
   :description "IXME: write description"
   :dependencies [[org.clojure/clojure "1.10.0"]
                  [metosin/compojure-api "1.1.13"]
                  [clj-time "0.14.3" :exclusions [org.slf4j/slf4j-log4j1 commons-logging]]]

   :ring {:handler clj1.handler/app}
   :jar-name "server.jar"
   :target-path "target/%s/"
   :repositories [["releases" {:url      "https://sforzando.artifactoryonline.com/sforzando/libs-release-local"
                               :username [:gpg :env/artifactory_user]
                               :password [:gpg :env/artifactory_pwd]}]
                  ["plugins" {:url      "https://sforzando.artifactoryonline.com/sforzando/plugins-release"
                              :username [:gpg :env/artifactory_user]
                              :password [:gpg :env/artifactory_pwd]}]]
   :container {:name       "pochta"
               :dockerfile "/docker"
               :hub        "sforzando-dockerv2-local.jfrog.io"}
   :dynamodb-local {:port 6798
                    :in-memory? true
                    :shared-db? true}
   :profiles {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]]
                    :plugins [[lein-ring "0.12.0"]
                              [lein-metajar "0.1.1"]
                              [lein-set-version "0.4.1"]
                              [clj-plugin "0.6.2"]
                              [lein-dynamodb-local "0.2.10"]]}
              :metajar {:direct-linking true
                        :aot :all
                        :source-paths   ["env/prod/clj"]
                        :resource-paths ["env/prod/resources"]}})




