package com.itheima.rumen7;

public class MovieOperator {
    private Movie[] movies;
    public MovieOperator(Movie[] movies) {
        this.movies = movies;
    }

    // 1 展示电影信息
    public void printAllMovies() {
        System.out.println("----------所有电影信息如下-------------：");
        for (int i = 0; i < movies.length; i++) {
            Movie movie = movies[i];
            System.out.println("编号" + movie.getId());
            System.out.println("名称" + movie.getName());
            System.out.println("价格" + movie.getPrice());
            System.out.println("---------------------------------");
        }
    }

    // 2 根据电影编号 查询电影详细信息
    public void searchMovieById(int id) {
        for (int i = 0; i < movies.length; i++) {
            Movie movie = movies[i];
            if (movie.getId() == id) {
                System.out.println("----------该电影详细信息如下-------------：");
                System.out.println("编号" + movie.getId());
                System.out.println("名称" + movie.getName());
                System.out.println("价格" + movie.getPrice());
                System.out.println("评分" + movie.getScore());
                System.out.println("导演" + movie.getDirector());
                System.out.println("主演" + movie.getActor());
                System.out.println("简介" + movie.getInfo());
                return;
            }
        }
        System.out.println("没有找到编号" + id + "的电影");
    }

}
