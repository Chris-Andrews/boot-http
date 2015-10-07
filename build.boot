(set-env!
 :source-paths #{"src" "test"}
 :dependencies '[[org.clojure/tools.nrepl "0.2.11"]
                 [org.clojure/clojure     "1.7.0"  :scope "provided"]
                 [boot/core               "2.3.0"  :scope "provided"]
                 [adzerk/bootlaces        "0.1.12" :scope "test"]
                 [adzerk/boot-test        "1.0.4"  :scope "test"]
                 [ring/ring-jetty-adapter "1.4.0"  :scope "test"]
                 [ring/ring-core          "1.4.0"  :scope "test"]
                 [ring/ring-devel         "1.4.0"  :scope "test"]])

(require
 '[adzerk.bootlaces :refer :all] ;; tasks: build-jar push-snapshot push-release
 '[adzerk.boot-test :refer :all]
 '[pandeiro.boot-http :refer :all])

(def +version+ "0.7.0-SNAPSHOT")

(bootlaces! +version+)

(task-options!
 pom {:project     'chris-andrews/boot-http
      :version     +version+
      :description "Boot task to serve HTTP."
      :url         "https://github.com/pandeiro/boot-http"
      :scm         {:url "https://github.com/pandeiro/boot-http"}
      :license     {"Eclipse Public License" "http://www.eclipse.org/legal/epl-v10.html"}})
