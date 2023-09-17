package chapter5;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamTest {
    private Trader raoul;
    private Trader mario;
    private Trader alan;
    private Trader brian;
    List<Transaction> transactions = new ArrayList<>();

    @BeforeEach
    void contextLoad() {
        raoul = new Trader("Raoul", "Cambridge");
        mario = new Trader("Mario", "Milan");
        alan = new Trader("Alan", "Cambridge");
        brian = new Trader("Brian", "Cambridge");

        transactions.add(new Transaction(brian, 2011, 300));
        transactions.add(new Transaction(raoul, 2012, 1000));
        transactions.add(new Transaction(raoul, 2011, 400));
        transactions.add(new Transaction(mario, 2012, 710));
        transactions.add(new Transaction(mario, 2012, 700));
        transactions.add(new Transaction(alan, 2012, 950));
    }

    @Test
    @DisplayName("2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리한다")
    void problem1() {
        List<Transaction> result = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .toList();

        assertThat(result).allMatch(t -> t.getYear() == 2011);
    }

    @Test
    @DisplayName("거래자가 근무하는 모든 도시를 중복 없이 나열하시오")
    void problem2() {
        List<String> result = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .toList();

        assertThat(result).containsExactlyInAnyOrder("Cambridge", "Milan");
    }

    @Test
    @DisplayName("케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오")
    void problem3() {
        List<Trader> result = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted(comparing(Trader::getName))
                .toList();

        assertThat(result).contains(alan, brian, raoul);
    }

    @Test
    @DisplayName("모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오")
    void problem4() {
        List<String> result = transactions.stream()
                .map(t -> t.getTrader())
                .distinct()
                .sorted(comparing(Trader::getName))
                .map(Trader::getName)
                .toList();

        assertThat(result).contains("Alan", "Brian", "Mario", "Raoul");
    }

    @Test
    @DisplayName("밀라노에 거래자가 있는가? ")
    void problem5() {
        boolean result = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("케임브리지에 거주하는 거래자의 모든 트랜잭션 값을 출력")
    void problem6() {
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("전체 트랜잭션 중 최댓값은 얼마인가?")
    void problem7() {
        Optional<Transaction> result = transactions.stream()
                .max(comparing(Transaction::getValue));

        assertThat(result.get().getValue()).isEqualTo(1000);
    }

    @Test
    @DisplayName("전체 트랜잭션 중 최솟값은 얼마인가?")
    void problem8() {
        Optional<Transaction> result = transactions.stream()
                .min(comparing(Transaction::getValue));

        assertThat(result.get().getValue()).isEqualTo(300);
    }
}
